package ru.testtask.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.testtask.pojo.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebUserDetails implements UserDetails {
    private final List<String> actions;
    private final User user;

    public WebUserDetails(User user, List<String> actions) {
        this.user = user;
        this.actions = actions;
    }

    public int getUserId() {
        return user.getId();
    }

    public String getRole() {
        return user.getRole();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> auths = new HashSet<>();
        for (String action : actions) {
            auths.add(new SimpleGrantedAuthority(action));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;//TODO temporaly is always true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;//TODO temporaly is always true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//TODO temporaly is always true
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();//TODO temporaly is always true
    }
}
