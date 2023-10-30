/*package com.mte2023.spring_mte.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mte2023.spring_mte.entities.Payment;
import com.mte2023.spring_mte.entities.Pedido_Coleta;
import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.entities.enums.Pedido_ColetaStatus;
import com.mte2023.spring_mte.repositories.Pedido_ColetaRepository;
import com.mte2023.spring_mte.repositories.UserRepisitory;

import org.springframework.transaction.annotation.Transactional;

@Configuration
@Transactional
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepisitory userRepisitory;

    @Autowired
    private Pedido_ColetaRepository pedido_ColetaRepository;

    @Override
    
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@email.com", "123456", "66666", null);
        User u2 = new User(null, "Raphael", "Raphael@email.com", "123456", "66666", null);

        Pedido_Coleta o1 = new Pedido_Coleta(null, Instant.parse("2019-06-20T19:53:07Z"), Pedido_ColetaStatus.PAID,u1);
        Pedido_Coleta o2 = new Pedido_Coleta(null, Instant.parse("2019-07-21T03:42:10Z"), Pedido_ColetaStatus.WAITING_PAYMENT,u2);
        Pedido_Coleta o3 = new Pedido_Coleta(null, Instant.parse("2019-07-22T15:21:22Z"), Pedido_ColetaStatus.WAITING_PAYMENT,u1);

        userRepisitory.saveAll(Arrays.asList(u1, u2));
        pedido_ColetaRepository.saveAll(Arrays.asList(o1, o2, o3));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        pedido_ColetaRepository.save(o1);
    }

}

 */