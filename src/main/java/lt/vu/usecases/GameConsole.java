package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Game;
import lt.vu.entities.Publisher;
import lt.vu.entities.User;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.PublishersDAO;
import lt.vu.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class GameConsole {

    @Inject
    private GamesDAO gamesDAO;

    @Getter @Setter
    private Game gameToAdd = new Game();

    @Inject
    private PublishersDAO publishersDAO;

    @Getter
    private Publisher publisher = new Publisher();

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer publisherId = Integer.parseInt(requestParameters.get("publisherId"));
        publisher = publishersDAO.findOne(publisherId);
    }

    @Transactional
    public String addGame(){
        gameToAdd.setPrice((float)(Math.round(gameToAdd.getPrice() * 100.0) / 100.0));
        gameToAdd.setPublisher(publisher);
        gamesDAO.persist(gameToAdd);
        return "admin";
    }
}
