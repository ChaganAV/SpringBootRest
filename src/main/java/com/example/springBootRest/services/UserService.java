package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private NotificationService notificationService;

    // внедряем через зависимости notificationService
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
