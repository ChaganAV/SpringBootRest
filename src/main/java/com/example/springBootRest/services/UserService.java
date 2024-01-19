package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Service;

/**
 * сервис добавления пользователей
 */
@Service
public class UserService {
    /**
     * сервис сообщений
     */
    private NotificationService notificationService;

    /**
     * внедряем зависимости notificationService через конструктор
     */
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * метод добавления пользователя
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return пользователь
     */
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
