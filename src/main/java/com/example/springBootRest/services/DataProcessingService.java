package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import com.example.springBootRest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    private UserRepository userRepository;

    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserRepository getUserRepository(){
        return userRepository;
    }
    public List<User> sortUserByAge(List<User> users){
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }
    public List<User> filterUserByAge(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }
    public double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
    public void addUserToList(User user){
        userRepository.getUsers().add(user);
    }
}
