package com.example.springBootRest.controllers;

import com.example.springBootRest.model.User;
import com.example.springBootRest.services.NotificationService;
import com.example.springBootRest.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController обработки донных с пользователями
 * по пути /users
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * внедряем сервис с набором сервисов
     * для работы с данными пользователями
     */
    @Autowired
    private RegistrationService services;

    /**
     * вывод списка пользователей
     * по пути контроллера (/users)
     * @return список пользователей
     */
    @GetMapping
    public List<User> userList(){
        return services.getDataProcessingService().getUserRepository().getUsers();
    }

    /**
     * Добавление пользователя из тела post запроса
     * если через postman, то в разделе body -> raw
     * вводим строку с данными пользователя,
     * в виде {"name":"Вася","age":23,"email":"vasya@gmail.com"}
     * по пути /users/body
     * @param user
     * @return сообщение об успешном добавлении пользователя
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        services.processRegistration(user);
        services.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "User added from body";
    }

    /**
     * метод добавления пользователя из параметров запроса
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return сообщение об успешном добавлении
     */
    @PostMapping("/param")
    public String userAddFromParam(@RequestParam(value="name") String name,
                                   @RequestParam(value="age") Integer age,
                                   @RequestParam(value="email") String email){
        User user = new User(name,age,email);
        services.processRegistration(user);
        services.getDataProcessingService().addUserToList(user);
        return "User added from param";
    }
}
