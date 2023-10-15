package com.mte2023.spring_mte.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.UserRepisitory;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepisitory userRepisitory;

    @Override
    public void run(String... args) throws Exception {
        
    }


}
