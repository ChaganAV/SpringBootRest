package com.example.springBootRest.controllers;

import com.example.springBootRest.model.User;
import com.example.springBootRest.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * rest контроллер обработки задач
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    /**
     * сервис обработки пользователей
     */
    private DataProcessingService service;

    /**
     * внедряем зависимости в конструкторе
     * @param service
     */
    public TaskController(DataProcessingService service) {
        this.service = service;
    }

    /**
     * получение списка задач, путь по пути контроллера (/tasks)
     * @return список задач
     */
    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * метод сортировки пользователей по возрасту
     * @return отсортированный список
     */
    @GetMapping("/sort") // localhost:8080/tasks/sort
    public List<User> sortUserByAge(){
        List<User> users = service.getUserRepository().getUsers();
        return service.sortUserByAge(users);
    }

    /**
     * фильтрация по возрасту
     * @param age возраст
     * @return отфильтрованный список
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable int age){
        List<User> users = service.getUserRepository().getUsers();
        return service.filterUserByAge(users, age);
    }

    /**
     * установка пути для метода получения среднего возраста пользователей
     * @return double среднее значение
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        List<User> users = service.getUserRepository().getUsers();
        return service.calculateAverageAge(users);
    }
}
