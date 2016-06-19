package services;


import jschool.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by anykey on 17.06.16.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User create(String firstName, String lastName, Date birthDay,
                       String login, String password, String aBout, String adress) {

        return new User(firstName, lastName, birthDay, login, password, aBout, adress);
    }

    @Override
    public User read(String login) {
        return null;
    }

    @Override
    public List<User> readAllUser() {
        return null;
    }

    @Override
    public User update(String fistName, String lastName, Date birthDay, String login, String password, String aBout, String adress) {
        return null;
    }

    @Override
    public void delete(String login) {

    }
}
