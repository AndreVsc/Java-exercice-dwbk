package com.atividade.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.atividade.demo.models.User;
import com.atividade.demo.utils.UserDataSource;

@Component
public class UserRepository {
    // Operações a fonte de dados

    @Autowired
    UserDataSource uDataSource;

    public List<User> getAllUsers() {
        return uDataSource.getDataSource();
    }

    public User getUserById(int id) {
        List<User> users = getAllUsers();
        return users.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(User user) {
        uDataSource.add(user);
    }

    public void deleteById(int id) {
        List<User> users = getAllUsers();
        users.removeIf(u -> u.getId() == id);
    }
}
