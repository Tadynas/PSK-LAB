package lt.vu.usecases.mybatis;

import lombok.Getter;
import lt.vu.mybatis.dao.GameMapper;
import lt.vu.mybatis.model.Game;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class PlayersConsoleMyBatis {

    @Inject
    private GameMapper gameMapper;

    @Getter
    private Game game;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer gameId = Integer.parseInt(requestParameters.get("gameId"));
        game = gameMapper.selectByPrimaryKey(gameId);
    }
}
