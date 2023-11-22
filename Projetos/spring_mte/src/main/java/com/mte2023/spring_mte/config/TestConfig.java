/*package com.mte2023.spring_mte.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mte2023.spring_mte.entities.CollectionOrder;
import com.mte2023.spring_mte.entities.Payment;
import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.CollectionOrderRepository;
import com.mte2023.spring_mte.repositories.UserRepisitory;

import org.springframework.transaction.annotation.Transactional;

@Configuration
@Transactional
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepisitory userRepisitory;

    @Autowired
    private CollectionOrderRepository collectionOrderRepository;

    @Override
    
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas", "lucas@email.com", "123456", "66666", null);
        User u2 = new User(null, "Raphael", "Raphael@email.com", "123456", "66666", null);

        CollectionOrder o1 = new CollectionOrder(null, Instant.parse("2019-06-20T19:53:07Z"), collectionOrderRepository.PAID,u1);
        CollectionOrder o2 = new CollectionOrder(null, Instant.parse("2019-07-21T03:42:10Z"), collectionOrderRepository.WAITING_PAYMENT,u2);
        CollectionOrder o3 = new CollectionOrder(null, Instant.parse("2019-07-22T15:21:22Z"), collectionOrderRepository.WAITING_PAYMENT,u1);

        userRepisitory.saveAll(Arrays.asList(u1, u2));
        collectionOrderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        collectionOrderRepository.save(o1);
    }

}*/