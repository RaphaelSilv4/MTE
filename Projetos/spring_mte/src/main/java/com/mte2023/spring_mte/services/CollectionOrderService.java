package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;
import com.mte2023.spring_mte.entities.CollectionOrder;
import com.mte2023.spring_mte.repositories.CollectionOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CollectionOrderService {

    @Autowired
    private CollectionOrderRepository collectionOrderRepository;

    //find methods
    public List<CollectionOrder> findAll(){
        return collectionOrderRepository.findAll();
    }

    public Optional<CollectionOrder> findById(Integer id){
        return collectionOrderRepository.findById(id);
    }

    //save methods
    public void save(CollectionOrder collectionOrder){
        collectionOrderRepository.save(collectionOrder);
    }
    public void saveAndFlush(CollectionOrder collectionOrder) { collectionOrderRepository.saveAndFlush(collectionOrder);}

    public void saveAll(List<CollectionOrder> collectionOrderList) { collectionOrderRepository.saveAll(collectionOrderList);}
    //delete methods
    public void delete(Integer id){
        collectionOrderRepository.deleteById(id);
    }
    //flush methods
    public void flush(){ collectionOrderRepository.flush();}
}
