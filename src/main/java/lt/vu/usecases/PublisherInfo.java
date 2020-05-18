package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Publisher;
import lt.vu.persistence.PublishersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
