package com.mte2023.spring_mte.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.UserRepisitory;

import org.springframework.transaction.annotation.Transactional;
/* Não mexam aqui, eu sem que tem coisas inutilizadas*/
@Configuration
@Transactional
public class TestConfig_PedidoColeta implements CommandLineRunner {
    
    @Autowired
    private UserRepisitory userRepisitory;

    @Override
    public void run(String... args) throws Exception {

        
    }
}
