package com.mte2023.spring_mte.resources;

import com.mte2023.spring_mte.entities.Product;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import com.mte2023.spring_mte.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
        throw new BadRequestException("Não foi encontrado nenhum produto", 404);
    }
    @Operation(summary = "Busca um determinado produto na base de dados a partir de seu identificador", method = "GET")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()){
            return new ResponseEntity<>(product , HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhum produto no id informado", 404);
    }

    @Operation(summary = "Realiza a inserção de um Produto na base de dados", method = "POST")
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        if(product != null){
            productService.saveAndFlush(product);
            return new ResponseEntity<>("Produto criado com sucesso.", HttpStatus.CREATED);
        }
        throw new BadRequestException("Erro ao criar o Produto.", 400);
    }
    @Operation(summary = "Realiza a remoção de um determinado produto na base de dados a partir do seu identificador", method = "DELETE")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id){
        if (productService.findById(id).isPresent()){
            productService.delete(id);
            return new ResponseEntity<>("Produto removido com sucesso.", HttpStatus.OK);
        }
        throw new BadRequestException("Erro ao deletar o produto.", 400);
    }
}
