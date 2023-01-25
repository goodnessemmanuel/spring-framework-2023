package com.ocheejeh.socialmedia.post.service;

import com.ocheejeh.socialmedia.post.Post;
import com.ocheejeh.socialmedia.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    ResponseEntity<Post> addPost(Integer userId, Post post);
    List<Post> getPostsByUser(User user);
    List<Post> getPosts();
}
