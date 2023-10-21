package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.Pedido_Coleta;
import com.mte2023.spring_mte.repositories.Pedido_ColetaRepository;

@Service
public class Pedido_ColetaService {
    
    @Autowired
    private Pedido_ColetaRepository repisitory;

    public List<Pedido_Coleta> findAll(){
        return repisitory.findAll();
    }

    public Pedido_Coleta findById(Long id){
        Optional<Pedido_Coleta> obj = repisitory.findById(id);
        return obj.get();
    }
}
