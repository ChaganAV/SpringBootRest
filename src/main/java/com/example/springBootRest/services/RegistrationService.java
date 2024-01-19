package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }
    public void processRegistration(User user){
        userService.createUser(user.getName(),user.getAge(), user.getEmail());
        notificationService.notifyUser(user);
    }
    public DataProcessingService getDataProcessingService(){
        return dataProcessingService;
    }
}
