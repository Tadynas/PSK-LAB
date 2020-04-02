package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Game;
import lt.vu.entities.Publisher;
import lt.vu.entities.User;
import lt.vu.interceptors.LoggedInvocation;
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
public class PublisherInfo {

    @Inject
    private PublishersDAO publishersDAO;

    @Getter
    private Publisher publisher;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer publisherId = Integer.parseInt(requestParameters.get("publisherId"));
        publisher = publishersDAO.findOne(publisherId);
    }
}
