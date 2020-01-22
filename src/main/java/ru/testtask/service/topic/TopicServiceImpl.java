package ru.testtask.service.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testtask.dao.TopicDao;
import ru.testtask.pojo.Topic;
import ru.testtask.pojo.User;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public boolean persistUserTopic(Topic topic, int userId) {
        return topicDao.persistUserTopic(topic, userId);
    }

    @Override
    public Topic getTopic(int topicId) {
        return topicDao.getTopicById(1);
    }

    @Override
    public List<Topic> getTopicList(User user) {
        return null;
    }


    @Override
    public List<Topic> getListAllTopics() {
        return topicDao.getListAllTopics().
                stream().
                sorted(Comparator.comparing(Topic::getStart_date)).
                collect(Collectors.toList());
    }

    @Override
    public void removeTopic(int topicId) {

    }
}
