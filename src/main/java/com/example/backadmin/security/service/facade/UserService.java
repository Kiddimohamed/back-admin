package com.example.backadmin.security.service.facade;


import com.example.backadmin.security.bean.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    String signIn(User user);


    List<User> findAll();

    User findByRef(String ref);


    User findByUsername(String username);



    User save(User user);

    public ResponseEntity<String> getAllService();

    public ResponseEntity<String> getAllServices();

    public int findServiceIfExist(String service);
}
