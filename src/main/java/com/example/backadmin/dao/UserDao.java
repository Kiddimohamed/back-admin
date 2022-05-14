package com.example.backadmin.dao;

//import com.example.agenceservicenumerique.bean.User;
import com.example.backadmin.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
User findByRef(String ref);
List<User> findAll();
}
