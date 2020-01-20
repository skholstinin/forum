package ru.testtask.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testtask.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "name", name);

    }

    @Override
    public User getUserBySurname(String surname) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "surname", surname);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        logger.info("UserDao login=" + login);
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "login", login);
    }

    @Override
    public boolean createUser(User user) {
        logger.info(user.toString());
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }

    private User getUserByCriteria(Session session, String criteria, String value) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get(criteria), value));
        Query<User> q = session.createQuery(query);
        List<User> resultList = q.getResultList();
        logger.info(resultList);
        if (resultList.isEmpty()) {
            logger.info("User not found");
            return null;
        }
        logger.info(resultList.get(0).toString());
        return resultList.get(0);
    }


}
