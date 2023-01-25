package com.ocheejeh.socialmedia.user.service.dao;

import com.ocheejeh.socialmedia.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
