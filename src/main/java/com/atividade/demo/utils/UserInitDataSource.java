package com.atividade.demo.utils;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.atividade.demo.models.*;

@Component
public class UserInitDataSource implements CommandLineRunner {
    @Autowired
    UserDataSource uDataSource;

    int countId = 1;
    @Override
    public void run(String... args) throws Exception {
        // User user = new User();
        // user.setId(1); 
        // user.setLogin("ifsp"); 
        // user.setPassword("1234"); 
        // uDataSource.add(user);
        
        Stream.generate(() -> {
            User user = new User();
            user.setId(++countId); 
            user.setLogin("IFSP " + user.getId()); 
            user.setPassword("1234"); 
            uDataSource.add(user);
            return user;
        }).limit(20);
    }
    // lógica para inicializar o DataSource
}
