package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Team;
import lt.vu.entities.User;
import lt.vu.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Users {

    @Inject
    private UsersDAO usersDAO;

    @Getter @Setter
    private User userToCreate = new User();

    @Getter
    private List<User> userList;

    @PostConstruct
    public void init(){
        loadUserList();
    }

    @Transactional
    public String createUser(){
        this.usersDAO.persist(userToCreate);
        return "index?faces-redirect=true";
    }

    private void loadUserList() {
        userList = usersDAO.loadAll();
    }
}
