package ru.testtask.dto;

public class RegistrationPageDTO {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String passwordDouble;

    public RegistrationPageDTO(String name, String surname, String login, String password, String passwordDouble) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.passwordDouble = passwordDouble;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordDouble() {
        return passwordDouble;
    }

    public void setPasswordDouble(String passwordDouble) {
        this.passwordDouble = passwordDouble;
    }
}
