package ru.testtask.dao;

import ru.testtask.pojo.User;
import ru.testtask.pojo.UserPost;

import java.util.List;

public interface PostDao {
    boolean persistUserPost(UserPost post, int userId);

    UserPost getPost(int postId);

    List<UserPost> getPostList(User user);

    void removePost(int postId);
}
