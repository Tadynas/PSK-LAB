package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Game;
import lt.vu.persistence.GamesDAO;
import lt.vu.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class Games {

    @Inject
    private GamesDAO GamesDAO;

    @Inject
    private UsersDAO usersDAO;

    @Getter
    private List<Game> allGames;

    @Getter
    private List<Game> libraryGames;

    @Getter
    private List<Game> shopGames;

    @PostConstruct
    public void init(){
        loadGameList();
    }

    private void loadGameList(){
        allGames = GamesDAO.loadAll();
    }


}
