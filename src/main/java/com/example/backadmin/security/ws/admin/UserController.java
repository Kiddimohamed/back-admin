package com.example.backadmin.security.ws.admin;


import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userControllerAdmin")
@RequestMapping("/api/v1/admin/user")
public class UserController {

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestBody User user) {
        return userService.signIn(user);
    }


    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }

    @GetMapping("/get-all-services")
    public ResponseEntity<String> getAllService() {
        return userService.getAllService();
    }


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
