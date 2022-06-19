package com.example.backadmin.security.service.impl;




import com.example.backadmin.security.bean.Role;
import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.dao.UserDao;
import com.example.backadmin.security.jwt.JwtResponse;
import com.example.backadmin.security.jwt.JwtUtil;
import com.example.backadmin.security.service.facade.RoleService;
import com.example.backadmin.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public JwtResponse signIn(User user) {
        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User loadUserByUsername = loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(loadUserByUsername);
        JwtResponse response = new JwtResponse(token);
        return response;
    }

//    @Override
//    public User findByEmail(String email) {
//        return userDao.findByUsername(email);
//    }

    @Override
    public User save(User user) {
        User loadedUser = userDao.findByUsername(user.getUsername());
        if (loadedUser != null)
            return null;
        else {
            Role role = new Role();
            role = roleService.findByAuthority("ROLE_ADMIN");
            Collection<Role> roles = new ArrayList<>();
            roles.add(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setAuthorities(roles);
            userDao.save(user);
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    //    sign Up user
//    s

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;


    //

    @Override
    public User findByReference(String ref) {
        return userDao.findByReference(ref);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    @Override
    public ResponseEntity<String> getAllService() {
        return null;
    }

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;


    @Override
    public ResponseEntity<String> getAllServices() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8096/v1/admin/service-demandeur/", HttpMethod.GET, entity, String.class);
        return response;
    }


    @Autowired
    private UserService userService;

    //microservice


    @Override
    public int findServiceIfExist(String service) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8096/v1/admin/service-demandeur/reference/" + service, HttpMethod.GET, entity, String.class);
        if (response.hasBody() == true) return -1;
        else return 1;

    }


    //    //statistique
    @Autowired
    protected EntityManager entityManager;
    public int findstatUsers() {
        return userDao.findstatUsers();
    }

}
