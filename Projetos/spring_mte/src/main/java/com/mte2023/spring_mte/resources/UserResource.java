package com.mte2023.spring_mte.resources;

import java.util.List;
import java.util.Optional;

import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.services.UserService;

@RestController
@RequestMapping(path = "/users", produces = "application/json;charset=UTF-8")
@Tag(name = "user")
public class UserResource {
    @Autowired
    UserService userService;
    @Operation(summary = "Busca todos os usuários na base de dados", method = "GET")
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userService.findAll();
        if (userList != null) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhum usuário no id informado", 404);
    }

    @Operation(summary = "Busca um determinado usuário na base de dados a partir de seu identificador", method = "GET")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        Optional<User> user = userService.findById(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user , HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhum usuário no id informado", 404);
    }

    @Operation(summary = "Realiza a inserção de um usuário na base de dados", method = "POST")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(user != null){
            userService.validate(user);
            userService.saveAndFlush(user);
            return new ResponseEntity<>("Usuário criado com sucesso.", HttpStatus.CREATED);
        }
        throw new BadRequestException("Erro ao criar o usuário.", 400);
    }
    @Operation(summary = "Realiza a remoção de um determinado usuário na base de dados a partir do seu identificador", method = "DELETE")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
        if (userService.findById(id).isPresent()){
            userService.delete(id);
            return new ResponseEntity<>("Usuário removido com sucesso.", HttpStatus.OK);
        }
        throw new BadRequestException("Erro ao deletar o usuário.", 400);
    }
/*
    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

     */
}