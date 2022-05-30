package com.example.backadmin.security.dao;

import com.example.backadmin.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByRef(String ref);
    User findByUsernameAndPassword(String username,String password);}