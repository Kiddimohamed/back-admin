package com.example.backadmin.ws;

import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/user")
public class UserWs {

    @GetMapping("/ref/{ref}")
    public User findByRef(@PathVariable String ref) {
        return userService.findByRef(ref);
    }

    @GetMapping("/Username/{name}") public User findByUsername(@PathVariable String name) {
        return userService.findByUsername(name);
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }


    @GetMapping("/") public List<User> findAll() {
        return userService.findAll();
    }

    @Autowired
    UserService userService;
}
