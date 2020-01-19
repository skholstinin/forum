package ru.testtask.service.user;

import ru.testtask.pojo.User;

public interface UserService {

    User getUserByLogin(String login);

    User getUserById(int id);

    void addUser(String name,
                 String surName,
                 String login,
                 String role,
                 String password);

}
