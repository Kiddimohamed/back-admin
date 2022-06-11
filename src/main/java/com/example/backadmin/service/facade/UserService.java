package com.example.backadmin.service.facade;


import com.example.backadmin.bean.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService  {


    List<User> findAll();

    User findByReference(String ref);


    User findByUsername(String username);



    User save(User user);

    public ResponseEntity<String> getAllService();

    public ResponseEntity<String> getAllServices();

    public int findServiceIfExist(String service);

    int findstatUsers();

    }
