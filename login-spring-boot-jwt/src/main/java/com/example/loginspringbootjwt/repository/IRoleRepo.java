package com.example.loginspringbootjwt.repository;

import com.example.loginspringbootjwt.model.Role;
import com.example.loginspringbootjwt.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
