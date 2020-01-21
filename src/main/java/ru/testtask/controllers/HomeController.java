package ru.testtask.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testtask.pojo.User;
import ru.testtask.security.Actions;
import ru.testtask.security.SecurityUtils;
import ru.testtask.service.topic.TopicService;
import ru.testtask.service.user.UserService;

@Controller
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);
    private UserService userService;
    private TopicService topicService;

    @Autowired
    public void setTopicService(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getIndex() {
        logger.info("Method HomeController");
        return "index";
    }

    @Secured(Actions.ENABLE_MAINPAGE_VIEW)
    @GetMapping(value = "/mainpage")
    public String showMainPage(Model model) {
        User user = userService.getUserByLogin(SecurityUtils.getAuthenticatedUsername());
        model.addAttribute("currentUser", user);
        model.addAttribute("topics", topicService.getListAllTopics());
        return "mainpage";
    }
}
