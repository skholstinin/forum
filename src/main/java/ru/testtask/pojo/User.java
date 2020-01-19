package ru.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;
    private List<RoleAction> roleActions = new ArrayList<>();
    private Set<UserPost> posts = new HashSet<>();


    public User(String name, String surname, String login, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String name, String surname, String login, String password, String role, List<RoleAction> roleActions) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
        this.roleActions = roleActions;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "role", updatable = false, insertable = false)
    public List<RoleAction> getRoleActions() {
        if (roleActions == null) {
            return new ArrayList<>();
        }
        return Collections.unmodifiableList(roleActions);
    }

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
//    public Set<UserPost> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<UserPost> posts) {
//        this.posts = posts;
//    }
}
