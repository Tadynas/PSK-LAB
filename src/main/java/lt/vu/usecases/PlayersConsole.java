package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Game;
import lt.vu.persistence.GamesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class PlayersConsole {

    @Inject
    private GamesDAO gamesDAO;

    @Getter
    private Game game;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer gameId = Integer.parseInt(requestParameters.get("gameId"));
        game = gamesDAO.findOne(gameId);
    }
}
