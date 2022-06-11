package com.example.backadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender2Service {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("marouansaif3@gmail.com");
        message.setTo("marouansaif123@gmail.com");
        message.setSubject("Test");
        message.setText(" hello Every Body");

        mailSender.send(message);
        System.out.println("mail  Send successfully....");

    }
}
