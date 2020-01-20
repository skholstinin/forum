package ru.testtask.service.topic;

import ru.testtask.pojo.Topic;
import ru.testtask.pojo.User;
import ru.testtask.pojo.UserPost;

import java.util.List;

public interface TopicService {
    boolean persistUserTopic(Topic topic, int userId);

    Topic getTopic(int topicId);

    List<Topic> getTopicList(User user);

    List<Topic> getListAllTopics();

    void removePost(int postId);
}
