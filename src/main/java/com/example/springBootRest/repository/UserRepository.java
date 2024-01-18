package com.example.springBootRest.repository;

import com.example.springBootRest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    public List<User> getUsers(){
        return users;
    }
    public void setUsers(List<User> users){
        this.users = users;
    }
}
