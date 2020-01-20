package ru.testtask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateTopicController {
    @GetMapping(value = "/createtopic")
    public String getTopic() {
        return "topic";
    }
}
