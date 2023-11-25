package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.mte2023.spring_mte.entities.Address;
import com.mte2023.spring_mte.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll(){ return addressRepository.findAll(); }

    public Optional<Address> findById(Integer id){ return addressRepository.findById(id);

    }
    public void save (Address address) { addressRepository.save(address);}
    public void saveAndFlush(Address address){ addressRepository.saveAndFlush(address);}
    public void saveAll(List<Address> addressList) { addressRepository.saveAll(addressList);}
    public void delete(Integer id){ addressRepository.deleteById(id);}
    public void flush(){addressRepository.flush();}

}
