package com.mte2023.spring_mte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mte2023.spring_mte.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
