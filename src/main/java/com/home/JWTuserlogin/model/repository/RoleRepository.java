package com.home.JWTuserlogin.model.repository;

import com.home.JWTuserlogin.model.entity.Role;
import com.home.JWTuserlogin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByAuthority(String authority);
}
