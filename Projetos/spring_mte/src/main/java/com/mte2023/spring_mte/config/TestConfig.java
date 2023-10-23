package com.mte2023.spring_mte.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mte2023.spring_mte.entities.Pedido_Coleta;
import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.Pedido_ColetaRepository;
import com.mte2023.spring_mte.repositories.UserRepisitory;

import org.springframework.transaction.annotation.Transactional;

@Configuration
@Transactional
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepisitory userRepisitory;

    @Autowired
    private Pedido_ColetaRepository pedido_ColetaRepositoryRepisitory;

    @Override
    
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@email.com", "123456", "66666", null);
        User u2 = new User(null, "Raphael", "Raphael@email.com", "123456", "66666", null);

        Pedido_Coleta o1 = new Pedido_Coleta(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Pedido_Coleta o2 = new Pedido_Coleta(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Pedido_Coleta o3 = new Pedido_Coleta(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepisitory.saveAll(Arrays.asList(u1, u2));
        pedido_ColetaRepositoryRepisitory.saveAll(Arrays.asList(o1, o2, o3));
    }

}