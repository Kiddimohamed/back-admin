package com.example.backadmin.ws;

import com.example.backadmin.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/EmailSender")
public class EmailSenderWs {
    @Autowired
    private EmailSenderService emailSenderService;
    @PostMapping("/{to}/{sujet}")
    public String  sendMail(@PathVariable String to,@PathVariable String sujet) {
        return emailSenderService.sendMail(to, sujet);
    }
}
