package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.CollectionOrder;
import com.mte2023.spring_mte.repositories.CollectionOrderRepository;

@Service
public class CollectionOrderService {
    
    @Autowired
    private CollectionOrderRepository collectionOrderRepository;

    public List<CollectionOrder> findAll(){
        return collectionOrderRepository.findAll();
    }

    public CollectionOrder findById(Long id){
        Optional<CollectionOrder> obj = collectionOrderRepository.findById(id);
        return obj.get();
    }
}
