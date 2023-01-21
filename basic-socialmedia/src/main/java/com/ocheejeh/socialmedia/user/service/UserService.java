package com.ocheejeh.socialmedia.user.service;

import com.ocheejeh.socialmedia.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private static List<User> users;
    static {
        users = List.of(
           new User(1, "James", LocalDate.now().minusYears(13)),
           new User(2, "Johnson", LocalDate.now().minusYears(19)),
           new User(3, "Daniel", LocalDate.now().minusYears(12))
        );
    }

    public List<User> findAllUsers(){
        return users;
    }

    public User findUserById(Integer id) {
      return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }
}
