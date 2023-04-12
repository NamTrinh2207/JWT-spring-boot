package com.example.loginspringbootjwt.service;

import com.example.loginspringbootjwt.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    User save(User user);
}
