package com.example.backadmin;

import com.example.backadmin.security.bean.Role;
import com.example.backadmin.security.bean.User;
import com.example.backadmin.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@SpringBootApplication
public class BackAdminApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackAdminApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if (true) {
            User admin = new User("admin", "admin");
            admin.setAuthorities(Arrays.asList(new Role("ROLE_ADMIN")));
            userService.save(admin);

            User chef = new User("chef", "chef");
            chef.setAuthorities(Arrays.asList(new Role("ROLE_CHEF")));
            userService.save(chef);
        }

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
