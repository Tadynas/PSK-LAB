package lt.vu.usecases.mybatis;

import lombok.Getter;
import lt.vu.mybatis.dao.PublisherMapper;
import lt.vu.mybatis.model.Publisher;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class PublishersMyBatis {

    @Inject
    private PublisherMapper publisherMapper;

    @Getter
    private List<Publisher> publisherList;

    @PostConstruct
    public void init(){
        loadPublisherList();
    }

    private void loadPublisherList(){
        publisherList = publisherMapper.selectAll();
    }


}
