package com.mte2023.spring_mte.repositories;

import com.mte2023.spring_mte.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Integer> {
}
