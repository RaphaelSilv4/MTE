package com.mte2023.spring_mte.resources;


import java.util.List;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mte2023.spring_mte.entities.Address;
import com.mte2023.spring_mte.services.AddressService;

@RestController
@RequestMapping(path = "/address", produces = "application/json;charset=UTF-8")
@Tag(name = "address")
public class AddressResource {
    @Autowired
    AddressService addressService;

    @Operation(summary = "Busca todos os endereços na base de dados", method = "GET")
    @GetMapping
    public ResponseEntity<?> getAllAddress(){
        List<Address> addressList = addressService.findAll();
        if (addressList != null) {
            return new ResponseEntity<>(addressList, HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhum endereço no id informado", 404);
    }
}
