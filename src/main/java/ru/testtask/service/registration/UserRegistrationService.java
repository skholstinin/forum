package ru.testtask.service.registration;

import ru.testtask.dto.RegistrationPageDTO;

public interface UserRegistrationService {
    boolean addUser(RegistrationPageDTO userPageDTO);

    RegistrationPageDTO createRegistrationPageInfo(String name, String surname, String login, String password, String passwordDouble);

    boolean isNameEmpty(RegistrationPageDTO registrationInfo);

    boolean isSurNameEmpty(RegistrationPageDTO registrationInfo);

    boolean isLoginEmpty(RegistrationPageDTO registrationInfo);

    boolean isPasswordEmpty(RegistrationPageDTO registrationInfo);

    boolean isPasswordDoubleEmpty(RegistrationPageDTO registrationInfo);

    boolean isPasswordEquals(RegistrationPageDTO registrationInfo);

    boolean isLoginUnique(RegistrationPageDTO registrationInfo);

    boolean validateLoginLengthAndContains(RegistrationPageDTO registrationInfo);

    boolean validateLength(String val, int len);

}
