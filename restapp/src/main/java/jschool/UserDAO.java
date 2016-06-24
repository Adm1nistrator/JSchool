package jschool;

import java.util.List;

/**
 * Created by Adm1n on 21.06.2016.
 */
public interface UserDAO {
    public void addUser(User user);
    public void updateUser(User user);
    public List<User> listUsers();
    public  User getUser(String login);
    public void removeUser(String login);

}
