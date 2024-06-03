package dao.impl;

import dao.UserDao;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateUtils;


public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl() {
        super(User.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE username = :username AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = query.uniqueResult();
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
