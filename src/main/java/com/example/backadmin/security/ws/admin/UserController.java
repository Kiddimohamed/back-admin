//package com.example.backadmin.security.ws.admin;
//
//
//import com.clubreservation.mother.security.bean.User;
//import com.clubreservation.mother.security.jwt.JwtResponse;
//import com.clubreservation.mother.security.service.facade.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController("userControllerAdmin")
//@RequestMapping("/api/v1/admin/user")
//@CrossOrigin("http://localhost:4200")
//public class UserController {
//
//    @PostMapping("/")
//    public User save(@RequestBody User user) {
//        return userService.save(user);
//    }
//
//    @PostMapping("/sign-in/")
//    public JwtResponse signIn(@RequestBody User user) {
//        return userService.signIn(user);
//    }
//
//    @GetMapping("/get-all")
//    public List<User> findAll() {
//        return userService.findAll();
//    }
//
//    @GetMapping("/username/{username}")
//    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
//        return userService.loadUserByUsername(username);
//    }
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Autowired
//    private UserService userService;
//}
