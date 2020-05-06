package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Game;
import lt.vu.entities.User;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.swing.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named
public class Store implements Serializable {

    @Inject
    private UsersDAO usersDAO;

    @Inject
    private GamesDAO gamesDAO;

    @Getter @Setter
    private User loggedUser;

    @Getter
    private List<Game> storeGames;

    @PostConstruct
    private void init() {
        loadUser();
        loadGames();
    }

    private void loadUser() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer userId = Integer.parseInt(requestParameters.get("userId"));
        loggedUser = usersDAO.findOne(userId);
    }

    private void loadGames(){
        storeGames = gamesDAO.loadAll();
        storeGames.removeAll(loggedUser.getPurchasedGames());
    }

    @Transactional
    @LoggedInvocation
    public String buyGame(Game game){
        try{
            loggedUser.getPurchasedGames().add(game);
            float remainingWalletAmount = Math.round((loggedUser.getWallet()-game.getPrice()) * 100.0f) / 100.0f;
            loggedUser.setWallet(remainingWalletAmount);
            usersDAO.update(loggedUser);
        } catch (OptimisticLockException e) {
            return "shop?faces-redirect=true&userId=" + loggedUser.getId() + "&error=optimistic-lock-exception";
        }
        return "shop?faces-redirect=true&userId=" + loggedUser.getId();
    }
}
