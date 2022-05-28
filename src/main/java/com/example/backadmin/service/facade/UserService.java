package com.example.backadmin.service.facade;

//import com.example.agenceservicenumerique.bean.User;

import com.example.backadmin.bean.User;

import java.util.List;

public interface UserService {
    User findByRef(String ref);
    User findByUsername(String name);

    int save(User user);

    List<User> findAll();
//    int save(User user);

}
