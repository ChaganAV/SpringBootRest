package com.example.springBootRest.repository;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * репозиторий хранения данных пользователей
 */
@Repository
public class UserRepository {
    /**
     * список пользователей
     */
    private List<User> users = new ArrayList<>();

    // region getters
    public List<User> getUsers(){
        return users;
    }
    public void setUsers(List<User> users){
        this.users = users;
    }
    // endregion
}
