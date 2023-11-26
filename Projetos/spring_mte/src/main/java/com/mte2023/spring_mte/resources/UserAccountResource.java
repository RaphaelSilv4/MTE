package com.mte2023.spring_mte.resources;

import com.mte2023.spring_mte.entities.User;
import com.mte2023.spring_mte.entities.UserAccount;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import com.mte2023.spring_mte.services.UserAccountService;
import com.mte2023.spring_mte.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user_account", produces = "application/json;charset=UTF-8")
@Tag(name = "user_account")
public class UserAccountResource {
    @Autowired
    UserAccountService userAccountService;
    @Operation(summary = "Busca todos as contas dos usuários na base de dados", method = "GET")
    @GetMapping
    public ResponseEntity<?> getAllUsersAccounts(){
        List<UserAccount> userAccountList = userAccountService.findAll();
        if (userAccountList != null) {
            return new ResponseEntity<>(userAccountList, HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhuma conta de usuário", 404);
    }

    @Operation(summary = "Busca uma determinado conta de usuário na base de dados a partir de seu identificador", method = "GET")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserAccountById(@PathVariable Integer id){
        Optional<UserAccount> userAccount = userAccountService.findById(id);
        if (userAccount.isPresent()){
            return new ResponseEntity<>(userAccount , HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhuma conta de usuário no id informado", 404);
    }

    @Operation(summary = "Realiza a inserção de um usuário na base de dados", method = "POST")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserAccount userAccount){
        if(userAccount != null){
            userAccountService.saveAndFlush(userAccount);
            return new ResponseEntity<>("Conta de Usuário criado com sucesso.", HttpStatus.CREATED);
        }
        throw new BadRequestException("Erro ao criar o usuário.", 400);
    }
    @Operation(summary = "Realiza a remoção de uma determinada conta de usuário na base de dados a partir do seu identificador", method = "DELETE")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUserAccountById(@PathVariable Integer id){
        if (userAccountService.findById(id).isPresent()){
            userAccountService.delete(id);
            return new ResponseEntity<>("Conta de Usuário removido com sucesso.", HttpStatus.OK);
        }
        throw new BadRequestException("Erro ao deletar a conta do usuário.", 400);
    }
}
