package com.realEstate.controller;

import com.realEstate.entity.Notification;
import com.realEstate.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createNotification(@RequestBody Notification notification) {
        notificationRepository.save(notification);
        return ResponseEntity.ok("Notification created successfully");
    }
}
