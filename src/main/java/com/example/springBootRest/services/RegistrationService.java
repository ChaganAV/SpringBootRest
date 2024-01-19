package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Service;

/**
 * Регистрация сервисов
 */
@Service
public class RegistrationService {
    /**
     * сервис обработки данных с пользователями
     */
    private DataProcessingService dataProcessingService;
    /**
     * сервис добавления пользователей
     */
    private UserService userService;
    /**
     * сервис сообщений
     */
    private NotificationService notificationService;

    /**
     * внедряем зависимости в конструкторе для Spring
     * если без конструктора, то можно воспользоваться
     * аннотацией @Autowired
     * @param dataProcessingService // сервис обработки данных
     * @param userService // сервис добавления пользователей
     * @param notificationService // сервис сообщений
     */
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * подключаем сервис добавления пользователя
     * и сервис сообщений
     * @param user пользователь
     */
    public void processRegistration(User user){
        userService.createUser(user.getName(),user.getAge(), user.getEmail());
        notificationService.notifyUser(user);
    }

    /**
     * метод возвращает сервис обработки данных
     * @return
     */
    public DataProcessingService getDataProcessingService(){
        return dataProcessingService;
    }
}
