package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.GameMapper;
import lt.vu.mybatis.dao.PublisherMapper;
import lt.vu.mybatis.model.Game;
import lt.vu.mybatis.model.Publisher;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class GameConsoleMyBatis {

    @Inject
    private GameMapper gameMapper;

    @Getter @Setter
    private Game gameToAdd = new Game();

    @Inject
    private PublisherMapper publisherMapper;

    @Getter
    private Publisher publisher = new Publisher();

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer publisherId = Integer.parseInt(requestParameters.get("publisherId"));
        publisher = publisherMapper.selectByPrimaryKey(publisherId);
    }

    @Transactional
    public String addGame(){
        gameToAdd.setPrice((Math.round(gameToAdd.getPrice() * 100.0) / 100.0));
        gameToAdd.setPublisherId(publisher.getId());
        gameMapper.insert(gameToAdd);
        return "admin";
    }
}
