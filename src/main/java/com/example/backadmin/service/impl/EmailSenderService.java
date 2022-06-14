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

import org.springframework.stereotype.Service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
@Service
public class EmailSenderService {


public String sendMail(String to,String sujet){


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

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("marouansaif3@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to)
        );
        message.setSubject(sujet);
        message.setText("http://localhost:4200/"+sujet);

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
    return "done";
    }


}
/*
class SendMailWithAttachment
{
    public static void main(String [] args)
    {
        String to="marouansaif123@gmail.com"; //Email address of the recipient
        final String user="marouansaif3@gmail.com"; //Email address of sender
        final String password="ggvvlylvxqfrplis";  //Password of the sender's email

        //Get the session object
        Properties properties = System.getProperties();

        //Here pass your smtp server url
        properties.setProperty("mail.smtp.host", "mail.javatpoint.com");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);    }   });

        //Compose message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Message Aleart");

            //Create MimeBodyPart object and set your message text
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("This is message body");

            //Create new MimeBodyPart object and set DataHandler object to this object
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = "C:\\Users\\User\\OneDrive\\Bureau\\Note_Encadrant.pdf";//change accordingly
            DataSource source = new FileDataSource(filename);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            //Create Multipart object and add MimeBodyPart objects to this object
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            //Set the multiplart object to the message object
            message.setContent(multipart );

            //Send message
            Transport.send(message);
            System.out.println("message sent....");

        }catch (MessagingException ex) {ex.printStackTrace();}
    }
}*/






