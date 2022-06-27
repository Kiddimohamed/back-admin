package com.example.backadmin;


import com.example.backadmin.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BackAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackAdminApplication.class, args);
    }


    @Autowired
    private UserService userService;


/*

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        senderService.sendEmail();
    }*/
}
