/*package com.mte2023.spring_mte.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mte2023.spring_mte.entities.Pedido_Coleta;
import com.mte2023.spring_mte.services.Pedido_ColetaService;

@RestController
@RequestMapping(value = "/pedido_coleta")
public class Pedido_ColetaResource {

    @Autowired
    private Pedido_ColetaService service;

    @GetMapping
    public ResponseEntity<List<Pedido_Coleta>> findAll(){
        List<Pedido_Coleta> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido_Coleta> findById(@PathVariable Long id){
        Pedido_Coleta obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
*/