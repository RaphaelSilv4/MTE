package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.UserRepisitory;

@Service
public class UserService {
    
    @Autowired
    private UserRepisitory repisitory;

    public List<User> findAll(){
        return repisitory.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repisitory.findById(id);
        return obj.get();
    }
}
