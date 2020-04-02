package lt.vu.usecases;

import lombok.extern.java.Log;
import lt.vu.entities.Game;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class BuyGame implements Serializable {

    private Integer userId;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        userId = Integer.parseInt(requestParameters.get("userId"));
    }

    @Transactional
    @LoggedInvocation
    public String buyGame(Game game){
        System.out.println(game.getPrice());
//        loggedUser.getPurchasedGames().add(game);
//        usersDAO.persist(loggedUser);
        return "shop?faces-redirect=true&userId=" + userId;
    }
}
