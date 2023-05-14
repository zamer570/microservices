package com.example.UserService.services;

import com.example.UserService.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    String deleteUser(String userId);

    String updateUser(User user);
}
