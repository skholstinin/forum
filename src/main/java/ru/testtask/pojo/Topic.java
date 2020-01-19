package ru.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {
    private String title;
    //    private User user;
    private int id;
    private int author_user_id;

    public Topic() {
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic(String title) {
        this.title = title;
    }

    @Column(name = "author_user_id")
    public int getAuthor_user_id() {
        return author_user_id;
    }

    public void setAuthor_user_id(int author_user_id) {
        this.author_user_id = author_user_id;
    }

    //    public User getUser() {
//        return user;
//    }

}
