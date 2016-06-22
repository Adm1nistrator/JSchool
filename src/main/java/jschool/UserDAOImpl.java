package jschool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adm1n on 21.06.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    public User getUser(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, login);
        return user;
    }

    @Override
    public void removeUser(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, login);
        if (user != null) {
            session.delete(user);
        }
    }
}
