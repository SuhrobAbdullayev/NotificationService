package com.kafka.notificationservice.controller;

import com.kafka.notificationservice.entity.Notifications;
import com.kafka.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationsController {

    private final NotificationService notificationService;

    @GetMapping("/all")
    public ResponseEntity<List<Notifications>> getAll(){
        List<Notifications> notificationsList = notificationService.getAllNotifications();
        return ResponseEntity.status(HttpStatus.OK).body(notificationsList);
    }


}
