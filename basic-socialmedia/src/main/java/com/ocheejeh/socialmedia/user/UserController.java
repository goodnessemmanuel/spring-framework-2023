package com.ocheejeh.socialmedia.user;

import com.ocheejeh.socialmedia.exception.UserNotFoundException;
import com.ocheejeh.socialmedia.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final UserService userService;

    public UserController(@Qualifier("UserServiceImplJpa") UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"","/"})
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if(user == null){
            throw new UserNotFoundException("id: " + id);
        }
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        //compose the current location of the newly created user and return it as response
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        LOG.debug("New user created, location is {}", location);
        return ResponseEntity.created(location).build();
    }
}
