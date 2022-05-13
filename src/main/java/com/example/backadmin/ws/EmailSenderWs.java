package com.example.backadmin.ws;


import com.example.backadmin.resource.EmailMessage;
import com.example.backadmin.service.facade.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderWs {
    private final EmailSenderService emailSenderService;

    public EmailSenderWs(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }


    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderService.sendEmail(emailMessage.getTo(),emailMessage.getSubject(),emailMessage.getMessage());

    return ResponseEntity.ok("Success");
    }
}
