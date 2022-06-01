package com.example.backadmin;


import com.example.backadmin.bean.User;
import com.example.backadmin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@SpringBootApplication
public class BackAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackAdminApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }
    @Autowired
    private UserService userService;
}
