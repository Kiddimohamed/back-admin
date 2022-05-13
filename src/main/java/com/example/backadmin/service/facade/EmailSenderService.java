package com.example.backadmin.service.facade;

public interface EmailSenderService {

    public void sendEmail(String to,String subject,String message);
}
