package ru.testtask.dao;

import ru.testtask.pojo.Topic;
import ru.testtask.pojo.User;

import java.util.List;

public interface TopicDao {
    boolean persistUserTopic(Topic topic, int userId);

    Topic getTopicById(int topicId);

    List<Topic> getTopicList(User user);

    List<Topic> getListAllTopics();

    void removeTopic(int topicId);

    boolean createNewTopic(Topic topic);
}
