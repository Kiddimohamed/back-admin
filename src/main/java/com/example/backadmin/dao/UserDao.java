package com.example.backadmin.dao;


import com.example.backadmin.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByReference(String ref);
    @Query("SELECT COUNT(u.id) FROM User u WHERE 1=1")
    public int findstatUsers();
}