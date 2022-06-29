package com.example.backadmin.ws;


import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.jwt.JwtResponse;
import com.example.backadmin.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/user")
public class UserWs {

    @GetMapping("/ref/{ref}")
    public User findByRef(@PathVariable String ref) {
        return userService.findByReference(ref);
    }

    @GetMapping("/Username/{name}")
    public User findByUsername(@PathVariable String name) {
        return userService.findByUsername(name);
    }

    @PostMapping("/save-admin")
    public User saveAdmin(@RequestBody User user) {
        return userService.saveAdmin(user);
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }


    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users")
    int findstatUsers() {
        return userService.findstatUsers();
    }

    @PostMapping("/sign-in/")
    public JwtResponse signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    public User findByReference(String ref) {
        return userService.findByReference(ref);
    }

//    public ResponseEntity<String> getAllService() {
//        return userService.getAllService();
//    }

//    public ResponseEntity<String> getAllServices() {
//        return userService.getAllServices();
//    }
//
//    public int findServiceIfExist(String service) {
//        return userService.findServiceIfExist(service);
//    }

    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }
    public UserWs(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    UserService userService;
}
