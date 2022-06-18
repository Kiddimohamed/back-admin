package com.example.backadmin.ws;

import com.example.backadmin.service.impl.EmailSenderService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/EmailSender")
public class EmailSenderWs {
    @Autowired
    private EmailSenderService emailSenderService;
    @GetMapping("/{to}/{sujet}")
    public String  sendMail(@PathVariable String to,@PathVariable String sujet) {
        return emailSenderService.sendMail(to, sujet);
    }
    @SneakyThrows
    @GetMapping("/{to}/{text}/{path}")
    public String sendEmailWithAttachFile(String to, String text,String path){
        return emailSenderService.sendEmailWithAttachFile(to,text,path);
    }
}
