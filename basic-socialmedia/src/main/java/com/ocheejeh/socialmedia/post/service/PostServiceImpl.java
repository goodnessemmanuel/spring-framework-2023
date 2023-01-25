package com.ocheejeh.socialmedia.post.service;

import com.ocheejeh.socialmedia.exception.UserNotFoundException;
import com.ocheejeh.socialmedia.post.Post;
import com.ocheejeh.socialmedia.post.service.dao.PostRepository;
import com.ocheejeh.socialmedia.user.User;
import com.ocheejeh.socialmedia.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public ResponseEntity<Post> addPost(Integer userId, Post post){
        User user =  userService.getUserById(userId);
        if(user == null)
            throw new UserNotFoundException("user with id:" + userId + " not found");

        post.setUser(user);
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        return postRepository.findPostByUser(user);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
