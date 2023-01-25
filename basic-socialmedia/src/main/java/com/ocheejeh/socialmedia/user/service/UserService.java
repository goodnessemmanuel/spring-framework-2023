package com.ocheejeh.socialmedia.user.service;

import com.ocheejeh.socialmedia.user.User;
import java.util.List;


public interface UserService{

    List<User> findAllUsers();

    User getUserById(Integer id);

    User addUser(User user);
}
