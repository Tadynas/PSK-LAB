package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Game;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class Games {

    @Inject
    private GamesDAO GamesDAO;

    @Getter
    private List<Game> allGames;

    @PostConstruct
    public void init(){
        loadGameList();
    }

    private void loadGameList(){
        allGames = GamesDAO.loadAll();
    }


}
