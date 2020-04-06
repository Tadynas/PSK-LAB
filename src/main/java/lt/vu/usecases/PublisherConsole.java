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
public class PublisherConsole {

    @Inject
    private PublishersDAO publishersDAO;

    @Getter
    @Setter
    private Publisher publisherToAdd = new Publisher();

    @Transactional
    public String addPublisher() {
        publishersDAO.persist(publisherToAdd);
        return "admin";
    }
}