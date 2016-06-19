package services;

import jschool.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by anykey on 17.06.16.
 */
public class UserDao implements UserService {

    // Injected database connection:
    @PersistenceContext
    private EntityManager entityManager;

    // Stores a new client:
    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }

    @Override
    public User create(String firstName, String lastName, Date birthDay, String login, String password, String aBout, String adress) {
        return null;
    }

    @Override
    public User read(String login) {
        return null;
    }

    @Override
    public List<User> readAllUser() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT g FROM User g ORDER BY g.login", User.class);
        return query.getResultList();

    }

    @Override
    public User update(String fistName, String lastName, Date birthDay, String login, String password, String aBout, String adress) {
        return null;
    }

    @Override
    public void delete(String login) {

    }
}
