package jschool.service;

import jschool.dao.User;

import java.util.List;

/**
 * Created by Adm1n on 22.06.2016.
 */
public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    List<User> listUsers();

    User getUser(String login);

    void removeUser(String login);


}
