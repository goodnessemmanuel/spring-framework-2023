package com.ocheejeh.socialmedia.user.service;

import com.ocheejeh.socialmedia.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static int countUser = 0;
    static {
        users.add( new User(++countUser, "James", LocalDate.now().minusYears(13)));
        users.add( new User(++countUser, "Johnson", LocalDate.now().minusYears(19)));
        users.add(new User(++countUser, "Daniel", LocalDate.now().minusYears(12)));
    }

    public List<User> findAllUsers(){
        return users;
    }

    public User findUserById(Integer id) {
      return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++countUser);
        users.add(user);
        return user;
    }
}
