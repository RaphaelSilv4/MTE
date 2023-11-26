package com.mte2023.spring_mte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mte2023.spring_mte.entities.CollectionOrder;


public interface CollectionOrderRepository extends JpaRepository<CollectionOrder, Integer>{
    
}
