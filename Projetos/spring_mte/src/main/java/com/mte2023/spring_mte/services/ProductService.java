package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.Product;
import com.mte2023.spring_mte.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //find methods
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    //save methods
    public void save(Product product){
        productRepository.save(product);
    }
    public void saveAndFlush(Product product) { 
        productRepository.saveAndFlush(product);
    }

    public void saveAll(List<Product> productList) { 
        productRepository.saveAll(productList);
    }
    //delete methods
    public void delete(Integer id){
        productRepository.deleteById(id);
    }
    //flush methods
    public void flush(){ productRepository.flush();}

}
