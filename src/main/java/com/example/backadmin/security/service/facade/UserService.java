package com.example.backadmin.security.service.facade;


import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.jwt.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    User save(User user);

    List<User> findAll();

    //    sign Up user
    JwtResponse signIn(User user);

    //    sign Up user
//    int signUpUser(Registration registration);


    User findByReference(String ref);


    User findByUsername(String username);


    public ResponseEntity<String> getAllService();

    public ResponseEntity<String> getAllServices();

    public int findServiceIfExist(String service);

    int findstatUsers();
}
