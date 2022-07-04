package com.example.backadmin.service.impl;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("marouansaif123@gmail.com");
        message.setTo("marouansaif3@gmail.com");
        message.setSubject("Test");
        message.setText(" hello Every Body");

        mailSender.send(message);
        System.out.println("mail  Send successfully....");

    }
}*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender emailSender;

    public String sendEmailWithAttachFile(String to, String text,String path)  {
        final String username = "marouansaif3@gmail.com";
        final String password = "ggvvlylvxqfrplis";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {


            Message message2 = new MimeMessage(session);
            message2.setFrom(new InternetAddress("marouansaif3@gmail.com"));
            message2.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message2.setSubject("demmande");
            message2.setText("http://localhost:4200/"+text);


            MimeMultipart mimeMultipart=new MimeMultipart();
            MimeBodyPart atachement =new MimeBodyPart();
            atachement.attachFile(new File(path));
            mimeMultipart.addBodyPart(atachement);
            message2.setContent(mimeMultipart);
            Transport.send(message2);
            System.out.println("Done");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return "done";
    }






    public String sendMail(String to, String sujet) {


        final String username = "marouansaif3@gmail.com";
        final String password = "ggvvlylvxqfrplis";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {


            Message message2 = new MimeMessage(session);
            message2.setFrom(new InternetAddress("marouansaif3@gmail.com"));
            message2.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message2.setSubject(sujet);
            message2.setText("http://localhost:4201/" + sujet);



            Transport.send(message2);
            System.out.println(to);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "done with attachement";
    }


}








