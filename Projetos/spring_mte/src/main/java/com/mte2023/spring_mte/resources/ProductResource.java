package com.mte2023.spring_mte.resources;

import com.mte2023.spring_mte.entities.Product;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import com.mte2023.spring_mte.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/product", produces = "application/json;charset=UTF-8")
@Tag(name = "product")
public class ProductResource {
    @Autowired
    ProductService productService;
    @Operation(summary = "Busca todos os produtos na base de dados", method = "GET")
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<Product> productList = productService.findAll();
        if (productList != null) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhum usuário no id informado", 404);
    }
}
