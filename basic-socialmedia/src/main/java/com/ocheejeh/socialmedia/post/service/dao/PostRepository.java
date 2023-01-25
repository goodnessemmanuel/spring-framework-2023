package com.ocheejeh.socialmedia.post.service.dao;

import com.ocheejeh.socialmedia.post.Post;
import com.ocheejeh.socialmedia.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostByUser(User user);
}
