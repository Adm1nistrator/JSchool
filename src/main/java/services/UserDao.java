package services;

import jschool.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by anykey on 17.06.16.
 */
@Component
public class UserDao {

    // Injected database connection:
    @PersistenceContext
    private EntityManager entityManager;

    // Stores a new client:
    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }


    public User create(String firstName, String lastName, Date birthDay, String login, String password, String aBout, String adress) {
        User user = new User(firstName, lastName, birthDay, login, password, aBout, adress);
        entityManager.persist(user);
        return user;
    }

    public User read(String login) {
        return null;
    }


    public List<User> readAllUser() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT g FROM User g ORDER BY g.login", User.class);
        return query.getResultList();

    }

    public User update(String fistName, String lastName, Date birthDay, String login, String password, String aBout, String adress) {
        return null;
    }

    public void delete(String login) {

    }
}
