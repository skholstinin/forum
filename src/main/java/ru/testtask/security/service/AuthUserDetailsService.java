package ru.testtask.security.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testtask.dao.UserDao;
import ru.testtask.pojo.RoleAction;
import ru.testtask.pojo.User;
import ru.testtask.security.model.WebUserDetails;

import java.util.stream.Collectors;

@Service("userDetails")
public class AuthUserDetailsService implements UserDetailsService {
    private static final Logger logger = Logger.getLogger(AuthUserDetailsService.class);
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        WebUserDetails webUserDetails;
        logger.info("username=" + username);
        User user = userDao.getUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found");
        }

        return new WebUserDetails(
                user,
                user.getRoleActions()
                        .stream()
                        .map(RoleAction::getAction)
                        .collect(Collectors.toList()));
    }
}
