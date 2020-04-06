package lt.vu.usecases.mybatis;

import lombok.Getter;
import lt.vu.mybatis.dao.GameMapper;
import lt.vu.mybatis.model.Game;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class GamesMyBatis {

    @Inject
    private GameMapper gameMapper;

    @Getter
    private List<Game> allGames;

    @PostConstruct
    public void init(){
        loadGameList();
    }

    private void loadGameList(){
        allGames = gameMapper.selectAll();
    }


}
