package com.example.loginspringbootjwt.service;

import com.example.loginspringbootjwt.model.Role;
import com.example.loginspringbootjwt.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
