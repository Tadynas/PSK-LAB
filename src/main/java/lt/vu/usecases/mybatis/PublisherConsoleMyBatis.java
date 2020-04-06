package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.PublisherMapper;
import lt.vu.mybatis.model.Publisher;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class PublisherConsoleMyBatis {

    @Inject
    private PublisherMapper publisherMapper;

    @Getter @Setter
    private Publisher publisherToAdd = new Publisher();

    @Transactional
    public String addPublisher() {
        publisherMapper.insert(publisherToAdd);
        return "admin";
    }
}