package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.mybatis.dao.GameMapper;
import lt.vu.mybatis.dao.UserGameMapper;
import lt.vu.mybatis.dao.UserMapper;
import lt.vu.mybatis.model.Game;
import lt.vu.mybatis.model.User;
import lt.vu.mybatis.model.UserGame;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
public class StoreMyBatis implements Serializable {

    @Inject
    private UserMapper userMapper;

    @Inject
    private GameMapper gameMapper;

    @Inject
    private UserGameMapper userGameMapper;

    @Getter @Setter
    private User loggedUser;

    @Getter
    private List<Game> storeGames = new ArrayList<Game>();
    private List<Game> purchasedGames = new ArrayList<Game>();


    @PostConstruct
    private void init() {
        loadUser();
        loadGames();
    }

    private void loadUser() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer userId = Integer.parseInt(requestParameters.get("userId"));
        loggedUser = userMapper.selectByPrimaryKey(userId);
    }

    private void loadGames(){
        storeGames = gameMapper.selectAll();
        purchasedGames = loggedUser.getPurchasedGames();
        for(Game purchasedGame : loggedUser.getPurchasedGames()) {
            storeGames.removeIf(game -> game.getId().equals(purchasedGame.getId()));
        }
    }

    @Transactional
    @LoggedInvocation
    public String buyGame(Game game){
        UserGame userGameToCreate = new UserGame();
        userGameToCreate.setUserId(loggedUser.getId());
        userGameToCreate.setGameId(game.getId());
        loggedUser.getPurchasedGames().add(game);
        loggedUser.setPurchasedGames(loggedUser.getPurchasedGames());
        userGameMapper.insert(userGameToCreate);
        return "shop?faces-redirect=true&userId=" + loggedUser.getId();
    }
}
