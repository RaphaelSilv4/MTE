package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    //find methods
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    //save methods
    public void save(User user){
        userRepository.save(user);
    }
    public void saveAndFlush(User user) { userRepository.saveAndFlush(user);}

    public void saveAll(List<User> userList) { userRepository.saveAll(userList);}
    //delete methods
    public void delete(Integer id){
        userRepository.deleteById(id);
    }
    //flush methods
    public void flush(){ userRepository.flush();}

    /*
    public User update(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
        entity.setPhone(obj.getPhone());

    }

     */
}
