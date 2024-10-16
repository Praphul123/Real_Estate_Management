package com.realEstate.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendEmail(String to, String subject, String message) {
        // Integrate email provider (like SendGrid)
        System.out.println("Sending email to " + to + ": " + subject);
    }

    public void sendSms(String to, String message) {
        // Integrate SMS provider (like Twilio)
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
