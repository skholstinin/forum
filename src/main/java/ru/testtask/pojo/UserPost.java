package ru.testtask.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_posts")
public class UserPost implements Serializable {
    private int id;
    private int theme_id;
    private String body;
    private Date start_date;
    private Date modify_date;
    private String style;
    //    private User user;
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

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "theme_id")
    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public UserPost setBody(String body) {
        this.body = body;
        return this;
    }

    @Column(name = "start_date")
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date date) {
        this.start_date = date;
    }

    @Column(name = "modify_date")
    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date date) {
        this.modify_date = date;
    }

    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return user_id;
    }

    public void setUserId(int id) {
        this.user_id = id;
    }

    @Column(name = "img_link")
    public String getImglink() {
        return imglink;
    }

    public void setImglink(String link) {
        this.imglink = link;
    }

    public UserPost setImgLink(String imglink) {
        this.imglink = imglink;
        return this;
    }

}
