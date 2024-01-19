package com.example.springBootRest.controllers;

import com.example.springBootRest.model.User;
import com.example.springBootRest.services.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private DataProcessingService service;

    public TaskController(DataProcessingService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort") // localhost:8080/tasks/sort
    public List<User> sortUserByAge(){
        List<User> users = service.getUserRepository().getUsers();
        return service.sortUserByAge(users);
    }
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable int age){
        List<User> users = service.getUserRepository().getUsers();
        return service.filterUserByAge(users, age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge(){
        List<User> users = service.getUserRepository().getUsers();
        return service.calculateAverageAge(users);
    }
}
