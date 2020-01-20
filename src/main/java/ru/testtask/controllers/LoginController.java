package ru.testtask.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @GetMapping(value = "/login")
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            Model model) {
        logger.info("Method LoginController");
        if (error != null && !error.isEmpty()) {
            model.addAttribute("loginError", "Bad login or password");
        }
        return "login";
    }

    @GetMapping(value = "/registration")
    public String showRegistrationForm(
            @RequestParam(value = "error", required = false) String error,
            Model model) {
        model.addAttribute("registrationError", error);
        return "registration";
    }
}
