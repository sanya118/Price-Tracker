package com.example.test.demo.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface NotificationService {
    void sendNotification(String alertMessage);
    void sendEmail(String alertMessage) throws AddressException, MessagingException, IOException;
}
