package com.ocheejeh.socialmedia.user.service;

import com.ocheejeh.socialmedia.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService{
    private static List<User> users = new ArrayList<>();
    private static int countUser = 0;
    static {
        users.add( new User(++countUser, "James", LocalDate.now().minusYears(13)));
        users.add( new User(++countUser, "Johnson", LocalDate.now().minusYears(19)));
        users.add(new User(++countUser, "Daniel", LocalDate.now().minusYears(12)));
    }

    @Override
    public List<User> findAllUsers(){
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public User addUser(User user) {
        user.setId(++countUser);
        users.add(user);
        return user;
    }
}
