package com.example.test.demo.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Override
    public void sendNotification(String alertMessage) {
        System.out.println(alertMessage);
    }

    @Override
    public void sendEmail(String alertMessage) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sanya.nitj@gmail.com", "focus@@@9");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sanya.nitj@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sanya.nitj@gmail.com"));
        msg.setSubject("Product Price Change Alert");
        msg.setContent(alertMessage, "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}
