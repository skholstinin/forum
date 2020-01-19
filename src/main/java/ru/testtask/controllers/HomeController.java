package ru.testtask.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        logger.info("Method HomeController");
        return "/index.jsp";
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String showMainPage() {
        return "mainpage";
    }
}
