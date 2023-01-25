package com.ocheejeh.socialmedia.user.service;

import com.ocheejeh.socialmedia.user.User;
import com.ocheejeh.socialmedia.user.service.dao.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("UserServiceImplJpa")
public class UserServiceImplJpa implements UserService {
    private UserRepository userRepository;

    public UserServiceImplJpa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
