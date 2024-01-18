package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("A new user has been create: " + user.getName());
    }
    public void sendNotification(String s){
        System.out.println(s);
    }
}
