package com.mte2023.spring_mte.services;

import com.mte2023.spring_mte.entities.UserAccount;
import com.mte2023.spring_mte.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    //find methods
    public List<UserAccount> findAll(){
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> findById(Integer id){
        return userAccountRepository.findById(id);
    }

    //save methods
    public void save(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }
    public void saveAndFlush(UserAccount userAccount) { userAccountRepository.saveAndFlush(userAccount);}

    public void saveAll(List<UserAccount> userAccountList) { userAccountRepository.saveAll(userAccountList);}
    //delete methods
    public void delete(Integer id){
        userAccountRepository.deleteById(id);
    }
    //flush methods
    public void flush(){ userAccountRepository.flush();}
}
