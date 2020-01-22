package ru.testtask.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.testtask.pojo.Topic;
import ru.testtask.pojo.User;
import ru.testtask.security.Actions;
import ru.testtask.service.topic.TopicService;

import java.util.Date;


@Controller
public class TopicController {
    private TopicService topicService;

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }


    @PostMapping(value = "/topic/{user_id}/0")
    public String createTopic(
            @PathVariable("user_id") int userId,
            @RequestParam(value = "topicTitle") String topicTitle, Model model) {

        Topic topic = new Topic()
                .setUser(new User().setId(userId))
                .setStart_date(new Date())
                .setTitle(topicTitle);
        topicService.persistUserTopic(topic, userId);
        model.addAttribute("topic", topic);
        return "topic";
    }

    @RequestMapping(value = "/topic/remove/{id}", method = RequestMethod.DELETE)
    public String removeTopic(@PathVariable("id") int topicId) {
        topicService.removeTopic(topicId);
        return "mainpage";
    }

}
