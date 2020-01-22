package ru.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.testtask.pojo.Topic;
import ru.testtask.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
@Transactional
public class TopicDaoImpl implements TopicDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean persistUserTopic(Topic topic, int userId) {
        Session session = sessionFactory.getCurrentSession();
        if (topic.getId() > 0) {
            topic.setUser(new User().setId(userId));
            session.merge(topic);
        } else {
            topic.setUser(session.get(User.class, userId));
            session.save(topic);
        }
        return true;
    }

    @Override
    public Topic getTopicById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Topic.class, id);
    }

    @Override
    public List<Topic> getTopicList(User user) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Topic> query = builder.createQuery(Topic.class);
        Root<Topic> root = query.from(Topic.class);
        query.select(root);
        Query<Topic> q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Topic> getListAllTopics() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Topic> query = builder.createQuery(Topic.class);
        Root<Topic> root = query.from(Topic.class);
        query.select(root);
        Query<Topic> q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public void removeTopic(int topicId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(new Topic().setId(topicId));
    }

    @Override
    public boolean createNewTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.save(topic);
        return true;
    }

    private Topic getTopicByCriteria(Session session, String criteria, String value) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Topic> query = builder.createQuery(Topic.class);
        Root<Topic> root = query.from(Topic.class);
        query.select(root).where(builder.equal(root.get(criteria), value));
        Query<Topic> q = session.createQuery(query);
        List<Topic> resultList = q.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}
