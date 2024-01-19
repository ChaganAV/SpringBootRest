package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Service;

/**
 * сервис сообщений
 */
@Service
public class NotificationService {
    /**
     * сообщение об успешном добавлении пользователя
     * @param user
     */
    public void notifyUser(User user){
        System.out.println("A new user has been create: " + user.getName());
    }
    public void sendNotification(String s){
        System.out.println(s);
    }

}
