package com.atividade.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.demo.dtos.CreateUserDTO;
import com.atividade.demo.models.User;
import com.atividade.demo.repositories.UserRepository;

@Service
public class UserService {
    // Casos de uso de usuário
    @Autowired
    UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User createUser(CreateUserDTO dto) {
        User newUser = new User();
        newUser.setId(generateNewId());
        newUser.setLogin(dto.getLogin());
        newUser.setPassword(dto.getPassword());
        userRepository.save(newUser);

        return newUser;
    }

    public User updateUser(int id, CreateUserDTO dto) {
        User existingUser = userRepository.getUserById(id);

        if (existingUser == null) {
            return null;
        }

        existingUser.setLogin(dto.getLogin());
        existingUser.setPassword(dto.getPassword());

        return existingUser;
    }

    public User deleteUser(int id) {
        User user = userRepository.getUserById(id);

        if (user == null) {
            return null;
        }

        userRepository.deleteById(id);
        return user;
    }

    private int generateNewId() {
        return userRepository.getAllUsers().stream()
                .mapToInt((user) -> user.getId())
                .max()
                .orElse(0) + 1;
    }
}
