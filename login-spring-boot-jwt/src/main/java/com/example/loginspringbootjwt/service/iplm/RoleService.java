package com.example.loginspringbootjwt.service.iplm;

import com.example.loginspringbootjwt.model.Role;
import com.example.loginspringbootjwt.model.RoleName;
import com.example.loginspringbootjwt.repository.IRoleRepo;
import com.example.loginspringbootjwt.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepo.findByName(name);
    }
}
