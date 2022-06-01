package com.example.backadmin.service.impl;

import com.example.backadmin.bean.User;
import com.example.backadmin.dao.UserDao;

import com.example.backadmin.service.facade.ServiceDemandeurService;
import com.example.backadmin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    ServiceDemandeurService serviceDemandeurService;



    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByRef(String ref) {
        return userDao.findByReference(ref);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    @Override
    public User save(User user) {
        //

        //User loadedUser = userDao.findByUsername(user.getUsername());
        //      ServiceDemandeur serviceDemandeur=serviceDemandeurService.findByReference(user.getServiceDemandeur().getReference());
        // user.setServiceDemandeur(serviceDemandeur);
        // if (loadedUser != null
            //|| serviceDemandeur==null
        // )
        //    return null;
        // else {
        //   user.setPassword(passwordEncoder.encode(user.getPassword()));

        //   roleService.save(user.getAuthorities());
        //   userDao.save(user);
          return userDao.save(user);
        // }
    }

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public ResponseEntity<String> getAllService() {
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
    public ResponseEntity<String> getAllServices() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8096/v1/admin/service-demandeur/", HttpMethod.GET, entity, String.class);
        return response;


    }

    @Override
    public int findServiceIfExist(String service){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8096/v1/admin/service-demandeur/reference/"+service, HttpMethod.GET, entity, String.class);
        if(response.hasBody()==true)return -1;
        else return 1;

    }




//    ///microservice
}
