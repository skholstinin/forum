package ru.testtask.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.testtask.dto.RegistrationPageDTO;
import ru.testtask.service.registration.UserRegistrationService;

@Controller
public class RegistrationController {
    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    private UserRegistrationService registrationService;

    @Autowired
    public void setUserRegistrationService(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/registration")
    public String registrationCheck(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "passwordDouble") String passwordDouble,
            Model model) {
        RegistrationPageDTO user = registrationService.createRegistrationPageInfo(name, surname, login, password, passwordDouble);
        if (!checkDataAndSetError(model, user)) {
            model.addAttribute("user", user);
            return "registration";
        }
        return addUser(user) ? "login" : "registration";
    }

    private boolean checkDataAndSetError(Model model, RegistrationPageDTO user) {
        boolean result = checkName(model, user);
        result &= checkSurName(model, user);
        result &= checkLogin(model, user);
        result &= checkPassword(model, user);
        return result;
    }

    private boolean checkName(Model model, RegistrationPageDTO user) {
        if (registrationService.isNameEmpty(user)) {
            model.addAttribute("firstNameError", "Не указано имя");
            return false;
        } else if (!registrationService.validateLength(user.getName(), 30)) {
            model.addAttribute("firstNameError", "Не должно быть больше 30 символов");
            return false;
        }
        return true;
    }

    private boolean checkSurName(Model model, RegistrationPageDTO user) {
        if (registrationService.isSurNameEmpty(user)) {
            model.addAttribute("surnameError", "Не указана фамилия");
            return false;
        } else if (!registrationService.validateLength(user.getSurname(), 40)) {
            model.addAttribute("surnameError", "Не должно быть больше 40 символов");
            return false;
        }
        return true;
    }

    private boolean checkLogin(Model model, RegistrationPageDTO user) {
        if (registrationService.isLoginEmpty(user)) {
            model.addAttribute("loginError", "Не указан логин");
            return false;
        } else if (!registrationService.isLoginUnique(user)) {
            model.addAttribute("loginError", "Данный логин уже используется");
            return false;
        } else if (!registrationService.validateLoginLengthAndContains(user)) {
            model.addAttribute("loginError", "Логин должен содержать хотя бы одну цифру, одну строчную и одну заглавную букву и один спецсимвол(из !@#$%)");
        }
        return true;
    }

    private boolean checkPassword(Model model, RegistrationPageDTO user) {
        boolean result = true;
        if (registrationService.isPasswordEmpty(user)) {
            model.addAttribute("passwordError", "Не введен пароль");
            result = false;
        }
        if (registrationService.isPasswordDoubleEmpty(user)) {
            model.addAttribute("passwordDoubleError", "Не введен пароль");
            result = false;
        }
        if (result && !registrationService.isPasswordEquals(user)) {
            model.addAttribute("passwordDoubleError", "Пароли не совпадают");
            result = false;
        }
        return result;
    }

    private boolean addUser(RegistrationPageDTO userDto) {
        return registrationService.addUser(userDto);
    }
}
