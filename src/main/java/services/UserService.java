package services;


import jschool.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by anykey on 17.06.16.
 */
public interface UserService {
    User create(String firstName, String lastName, Date birthDay,
                String login, String password, String aBout, String adress);

    User read(String login);
    List<User> readAllUser();

    User update(String fistName, String lastName, Date birthDay,
                String login, String password, String aBout, String adress);
    void delete (String login);




}