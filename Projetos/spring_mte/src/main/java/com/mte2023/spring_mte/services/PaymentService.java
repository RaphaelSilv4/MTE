package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.Payment;
import com.mte2023.spring_mte.repositories.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository PaymentRepository;

     //find methods
    public List<Payment> findAll(){
        return PaymentRepository.findAll();
    }

    public Optional<Payment> findById(Integer id){
        return PaymentRepository.findById(id);
    }

    //save methods
    public void save(Payment collectionOrder){
        PaymentRepository.save(collectionOrder);
    }
    public void saveAndFlush(Payment collectionOrder) { PaymentRepository.saveAndFlush(collectionOrder);}

    public void saveAll(List<Payment> collectionOrderList) { PaymentRepository.saveAll(collectionOrderList);}
    //delete methods
    public void delete(Integer id){
        PaymentRepository.deleteById(id);
    }
    //flush methods
    public void flush(){ PaymentRepository.flush();}
}

