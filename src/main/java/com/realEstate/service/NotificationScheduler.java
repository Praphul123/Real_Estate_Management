package com.realEstate.service;

import com.realEstate.entity.Notification;
import com.realEstate.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationScheduler {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @Scheduled(fixedRate = 60000)  // Run every minute
    public void sendScheduledNotifications() {
        List<Notification> notifications = notificationRepository.findByScheduledTimeBefore(LocalDateTime.now());
        for (Notification notification : notifications) {
            if ("EMAIL".equals(notification.getType())) {
                emailService.sendEmail(notification.getRecipient(), "Reminder", notification.getMessage());
            } else if ("SMS".equals(notification.getType())) {
                smsService.sendSms(notification.getRecipient(), notification.getMessage());
            }
            notificationRepository.delete(notification);  // Delete after sending
        }
    }
}

