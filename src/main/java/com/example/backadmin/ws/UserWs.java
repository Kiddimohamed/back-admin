package com.example.backadmin.ws;

import com.example.backadmin.bean.User;
import com.example.backadmin.service.facade.UserService;
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

    @GetMapping("/username/{name}") public User findByUserName(@PathVariable String name) {
        return userService.findByUserName(name);
    }

    @PostMapping("/")
    public int save(@RequestBody User user) {
        return userService.save(user);
    }


    @GetMapping("/") public List<User> findAll() {
        return userService.findAll();
    }

    @Autowired
    UserService userService;
}
