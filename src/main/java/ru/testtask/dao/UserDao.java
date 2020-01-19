package ru.testtask.dao;

import ru.testtask.pojo.User;

public interface UserDao {
    User getUserByName(String name);

    User getUserBySurname(String surname);

    User getUserById(int id);

    User getUserByLogin(String login);

    boolean createUser(User user);
}
