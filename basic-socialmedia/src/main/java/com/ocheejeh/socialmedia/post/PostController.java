package com.ocheejeh.socialmedia.post;

import com.ocheejeh.socialmedia.exception.UserNotFoundException;
import com.ocheejeh.socialmedia.post.service.PostService;
import com.ocheejeh.socialmedia.user.User;
import com.ocheejeh.socialmedia.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable Integer userId){
        User user =  userService.getUserById(userId);
        if(user == null)
            throw new UserNotFoundException("user with id: " + userId + " not found");

      return postService.getPostsByUser(user);
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> addUserPost(@PathVariable Integer userId, @RequestBody Post post){
        return postService.addPost(userId, post);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getPosts();
    }
}
