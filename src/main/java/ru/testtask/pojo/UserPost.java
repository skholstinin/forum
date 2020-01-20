package ru.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_posts")
public class UserPost implements Serializable {
    private int id;
    private int topic_id;
    private Topic topic;
    private String body;
    private Date start_date;
    private Date modify_date;
    private String style;
    private User user;
    private int user_id;
    private String imglink;

    public UserPost() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public UserPost setId(int id) {
        this.id = id;
        return this;
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public UserPost setBody(String body) {
        this.body = body;
        return this;
    }

    @Column(name = "topic_id")
    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    @Column(name = "img_link")
    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    public User getUser() {
//        return user;
//    }
//
//    public UserPost setUser(User user) {
//        this.user = user;
//        return this;
//    }
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "topic_id")
//    public Topic getTopic(){
//        return topic;
//    }
//
//    public UserPost setTopic(Topic topic){
//        this.topic = topic;
//        return this;
//    }

}
