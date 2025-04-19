package com.atividade.demo.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.atividade.demo.models.User;

@Component
public class UserDataSource {
    // Simula fonte de dados da aplicação
    private List<User> datasource;

    public UserDataSource() {
        datasource = new ArrayList<>();
    }

    public List<User> getDataSource(){
        return datasource;
    }

    public void add(User user) {
        datasource.add(user);
    }
}
