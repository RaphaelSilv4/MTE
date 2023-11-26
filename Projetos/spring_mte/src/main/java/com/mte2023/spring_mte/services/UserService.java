package com.mte2023.spring_mte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
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
    public void saveAndFlush(User user) { 
        userRepository.saveAndFlush(user);
    }
    public void saveAll(List<User> userList) { 
        userRepository.saveAll(userList);
    }

    //delete methods
    public void delete(Integer id){
        userRepository.deleteById(id);
    }
    //flush methods
    public void flush(){ 
        userRepository.flush();
    }
    
    public User update(Integer id, User obj){
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

    //Logic Methods
    public void validate(User user) {

        String validateName = validateName(user.getName());
        if (validateName != null) {
            throw new BadRequestException("Erro em usuário: " + validateName, 400);
        }

        String validatePassword = validatePassword(user.getPassword(), user.getName());
        if (validatePassword != null) {
            throw new BadRequestException("Erro em usuário: " + validatePassword, 400);
        }
    }

    private String validatePassword(String senha, String name) {
        if (senha == null || senha.isEmpty()) {
            return "A senha não pode estar vazia.";
        }

        if (senha.length() < 8) {
            return "A senha deve ter pelo menos 8 caracteres.";
        }

        if (!senha.matches(".*[A-Z].*")) {
            return "A senha deve conter pelo menos uma letra maiúscula.";
        }

        if (senha.matches(".*[/\\-, %#$^*?_~&.].*")) {
            return "A senha não pode conter os seguintes símbolos especiais: '/', '-', ',' , '%', '#', '$', '^', '*', '?', '_', '~', '&','.'";
        }

        if (isPasswordRepeated(senha)) {
            return "A senha não pode consistir em todos os caracteres iguais.";
        }

        if (senha.equals(name)) {
            return "A senha não pode ser igual ao nome de usuário.";
        }

        return null;
    }

    private boolean isPasswordRepeated(String senha) {
        char[] senhaChars = senha.toCharArray();
        char primeiroChar = senhaChars[0];
        for (char c : senhaChars) {
            if (c != primeiroChar) {
                return false;
            }
        }
        return true;
    }

    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            return "O nome de usuário não pode estar vazio.";
        }

        if (name.length() < 3 || name.length() > 30) {
            return "O nome de usuário deve ter entre 3 e 30 caracteres.";
        }

        if (!name.matches("^[a-zA-Z]+$")) {
            return "O nome de usuário só pode conter letras.";
        }

        return null;
    }

}