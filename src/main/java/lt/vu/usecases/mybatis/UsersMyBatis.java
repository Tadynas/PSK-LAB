package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.UserMapper;
import lt.vu.mybatis.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class UsersMyBatis {

    @Inject
    private UserMapper userMapper;

    @Getter
    private List<User> userList;

    @Getter @Setter
    private String username, password;

    @PostConstruct
    public void init(){
        loadUserList();
    }

    private void loadUserList(){
        userList = userMapper.selectAll();
    }

    @Transactional
    public String createUser(){
        User userToCreate = new User();
        userToCreate.setUsername(username);
        userToCreate.setPassword(password);
        userMapper.insert(userToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String validate(){
        if(username.equals("admin") && password.equals("admin"))
        {
            return "admin";
        }
        else
        {
            for (User user : getUserList()) {
                if (user.getUsername().toLowerCase().equals(username.toLowerCase()) &&
                        user.getPassword().equals(password)) {
                    System.out.println(user.getId());
                    return "library?faces-redirect=true userId=" + user.getId();
                }
            }
        }
        return "index";
    }
}
