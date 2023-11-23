
package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.Address;
import com.mte2023.spring_mte.repositories.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository repository;

    public List<Address> findAll(){
        return repository.findAll();
    }

    public Address findById(Long id){
        Optional<Address> obj = repository.findById(id);
        return obj.get();
    }

    public Address insert(Address obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Address update(Long id, Address obj){
        Address entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Address entity, Address obj) {
        entity.setCep(obj.getCep());
        entity.setNumero_casa(obj.getNumero_casa());
        entity.setNome_bairro(obj.getNome_bairro());
        entity.setCidade(obj.getCidade());
        entity.setEstado_federativo(obj.getEstado_federativo());

    }
}