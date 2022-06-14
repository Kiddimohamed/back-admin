package com.example.backadmin.service.impl;

import com.example.backadmin.bean.User;
import com.example.backadmin.dao.UserDao;
import com.example.backadmin.service.facade.UserService;
import com.example.backadmin.service.facade.ServiceDemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    ServiceDemandeurService serviceDemandeurService;

//    @Override
//    public String signIn(User user) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    user.getUsername(), user.getPassword()
//            ));
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
//        }
//        User loadUserByUsername = loadUserByUsername(user.getUsername());
//        String token = jwtUtil.generateToken(loadUserByUsername);
//        return token;
//    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByReference(String ref) {
        return userDao.findByReference(ref);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    @Override
    public User save(User user) {
        //

//        User loadedUser = userDao.findByReference(user.getReference());
        //      ServiceDemandeur serviceDemandeur=serviceDemandeurService.findByReference(user.getServiceDemandeur().getReference());
        // user.setServiceDemandeur(serviceDemandeur);
//         if (loadedUser != null)
//         {}else {
//             userDao.save(loadedUser);
//         }
        return userDao.save(user);
        // }
    }

    @Override
    public ResponseEntity<String> getAllService() {
        return null;
    }


//    @Override
//    public User loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.findByUsername(username);
//        if (user == null || user.getId() == null) {
//            throw new UsernameNotFoundException("user " + username + " not founded");
//        } else {
//            return user;
//        }
//
//    }

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
    UserService userService;

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