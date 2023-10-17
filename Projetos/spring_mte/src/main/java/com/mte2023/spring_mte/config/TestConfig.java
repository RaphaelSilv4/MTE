package com.mte2023.spring_mte.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.UserRepisitory;

import org.springframework.transaction.annotation.Transactional;

@Configuration
@Transactional
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepisitory userRepisitory;

    @Override
    
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@email.com", "123456", "66666", null);
        User u2 = new User(null, "Raphael", "Raphael@email.com", "123456", "66666", null);

        userRepisitory.saveAll(Arrays.asList(u1, u2));
    }

}