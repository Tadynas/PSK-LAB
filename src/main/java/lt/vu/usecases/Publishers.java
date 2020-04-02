package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Publisher;
import lt.vu.persistence.PublishersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class Publishers {

    @Inject
    private PublishersDAO PublishersDAO;

    @Getter
    private List<Publisher> publisherList;

    @PostConstruct
    public void init(){
        loadPublisherList();
    }

    private void loadPublisherList(){
        publisherList = PublishersDAO.loadAll();
    }


}
