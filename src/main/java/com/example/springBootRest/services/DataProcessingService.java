package com.example.springBootRest.services;

import com.example.springBootRest.model.User;
import com.example.springBootRest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис обработки данных о пользователях
 */
@Service
public class DataProcessingService {
    /**
     * репозиторий с пользователями
     */
    private UserRepository userRepository;

    /**
     * внедряем зависимость с репозиторием через конструктор
     * @param userRepository
     */
    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * получение репозитория
     * @return репозиторий с пользователями
     */
    public UserRepository getUserRepository(){
        return userRepository;
    }

    /**
     * метод сортировки пользователей по возрасту
     * @param users список пользователей
     * @return отсортированный список
     */
    public List<User> sortUserByAge(List<User> users){
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * метов фильтрации по возрасту
     * @param users список пользователей
     * @param age возраст для фильтра
     * @return отфильтрованный список
     */
    public List<User> filterUserByAge(List<User> users, int age){
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * метод подсчета среднего возраста всех пользователей
     * @param users список пользотелей
     * @return double средний возраст
     */
    public double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * добавление пользователя в список
     * @param user пользователь
     */
    public void addUserToList(User user){
        userRepository.getUsers().add(user);
    }
}
