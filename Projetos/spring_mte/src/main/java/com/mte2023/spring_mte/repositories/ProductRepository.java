package com.mte2023.spring_mte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mte2023.spring_mte.entities.Product;

public interface ProductRepository extends JpaRepository<Product , Integer> {
}
