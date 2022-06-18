package com.example.backadmin.security.dao;


import com.example.backadmin.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
//    User findByEmail(String email);

    User findByUsername(String username);

    User findByReference(String ref);

    List<User> findAll();

    @Query("SELECT COUNT(u.id) FROM User u WHERE 1=1")
    public int findstatUsers();
}
