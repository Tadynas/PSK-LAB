package lt.vu.usecases.mybatis;

import lombok.Getter;
import lt.vu.mybatis.dao.PublisherMapper;
import lt.vu.mybatis.model.Publisher;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class PublisherInfoMyBatis {

    @Inject
    private PublisherMapper publisherMapper;

    @Getter
    private Publisher publisher;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer publisherId = Integer.parseInt(requestParameters.get("publisherId"));
        publisher = publisherMapper.selectByPrimaryKey(publisherId);
    }
}
