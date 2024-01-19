package com.example.springBootRest.controllers;

import com.example.springBootRest.model.User;
import com.example.springBootRest.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;
    @GetMapping
    public List<User> userList(){
        return registrationService.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        registrationService.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "User added from body";
    }
}
