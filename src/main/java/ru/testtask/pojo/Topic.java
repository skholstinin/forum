package ru.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {
    private String title;
    private User user;
    private Date start_date;
    private Date modify_date;
    private int id;
    private int author_user_id;

    public Topic(String title, Date start_date, int author_user_id) {
        this.title = title;
        this.start_date = start_date;
        this.author_user_id = author_user_id;
    }

    public Topic() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public Topic setId(int id) {
        this.id = id;
        return this;
    }
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name = "start_date")
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Column(name = "modify_date")
    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }
    @Column(name = "author_user_id")
    public int getAuthor_user_id() {
        return author_user_id;
    }

    public void setAuthor_user_id(int author_user_id) {
        this.author_user_id = author_user_id;
    }

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    public User getUser() {
//        return user;
//    }
//
//    public Topic setUser(User user) {
//        this.user = user;
//        return this;
//    }

}
