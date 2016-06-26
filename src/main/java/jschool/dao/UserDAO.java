package jschool.dao;

import java.util.List;

/**
 * Created by Adm1n on 21.06.2016.
 */
public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    List<User> listUsers();
    User getUser(String login);
    void removeUser(String login);

}
