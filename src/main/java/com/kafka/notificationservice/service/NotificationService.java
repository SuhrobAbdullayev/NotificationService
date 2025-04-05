package com.kafka.notificationservice.service;
import com.kafka.notificationservice.entity.Notifications;
import com.kafka.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "notification", groupId = "notify")
    public void listener(String message){
        Notifications notifications = new Notifications();
        notifications.setMessage(message);
        notificationRepository.save(notifications);
        System.out.println(message);
    }

    public List<Notifications> getAllNotifications(){
        List<Notifications> notificationsList = notificationRepository.findAll();
        return notificationsList;
    }

}
