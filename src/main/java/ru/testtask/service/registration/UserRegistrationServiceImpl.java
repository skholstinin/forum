package ru.testtask.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.testtask.dao.UserDao;
import ru.testtask.dto.RegistrationPageDTO;
import ru.testtask.pojo.User;
import ru.testtask.security.model.Roles;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean addUser(RegistrationPageDTO userPageDTO) {
        userPageDTO.setPassword(passwordEncoder.encode(userPageDTO.getPassword()));
        userPageDTO.setPasswordDouble(userPageDTO.getPassword());
        User user = convertUserDtpToUserPojo(userPageDTO);
        return userDao.createUser(user);
    }

    @Override
    public RegistrationPageDTO createRegistrationPageInfo(String name, String surname, String login, String password, String passwordDouble) {
        return new RegistrationPageDTO(name, surname, login, password, passwordDouble);
    }

    @Override
    public boolean isNameEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getName().isEmpty();
    }

    @Override
    public boolean isSurNameEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getSurname().isEmpty();
    }

    @Override
    public boolean isLoginEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getLogin().isEmpty();
    }

    @Override
    public boolean isPasswordEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getPassword().isEmpty();
    }

    @Override
    public boolean isPasswordDoubleEmpty(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getPasswordDouble().isEmpty();
    }

    @Override
    public boolean isPasswordEquals(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getPassword().equals(registrationInfo.getPasswordDouble());
    }

    @Override
    public boolean isLoginUnique(RegistrationPageDTO registrationInfo) {
        return userDao.getUserByLogin(registrationInfo.getLogin()) == null;
    }

    @Override
    public boolean validateLoginLengthAndContains(RegistrationPageDTO registrationInfo) {
        return registrationInfo.getLogin().matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
    }

    @Override
    public boolean validateLength(String val, int len) {
        return val != null && val.length() <= len;
    }

    private User convertUserDtpToUserPojo(RegistrationPageDTO pageDTO) {
        User user = new User();
        user.setRole(Roles.ROLE_USER);
        user.setName(pageDTO.getName());
        user.setSurname(pageDTO.getSurname());
        user.setLogin(pageDTO.getLogin());
        user.setPassword(pageDTO.getPassword());
        user.setEnabled(true);
        return user;
    }
}
