package com.mte2023.spring_mte.resources;

import java.util.List;
import java.util.Optional;

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

import com.mte2023.spring_mte.entities.CollectionOrder;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import com.mte2023.spring_mte.services.CollectionOrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(path = "/collection_order", produces = "application/json;charset=UTF-8")
@Tag(name = "collection_order")
public class CollectionOrderResource {

    @Autowired
    private CollectionOrderService collectionOrderService;

    @Operation(summary = "Busca todos os pedidos de coleta na base de dados", method = "GET")
    @GetMapping
    public ResponseEntity<?> getCollectionOrder(){
        List<CollectionOrder> collectionOrderList = collectionOrderService.findAll();
        if (collectionOrderList != null) {
            return new ResponseEntity<>(collectionOrderList, HttpStatus.OK);
        }
        throw new BadRequestException("Nenhum ordem de coleta cadastrada no banco", 404);
    }

    @Operation(summary = "Busca uma determinado coleta na base de dados a partir de seu identificador", method = "GET")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCollectionOrderById(@PathVariable Integer id){
        Optional<CollectionOrder> collectionOrder = collectionOrderService.findById(id);
        if (collectionOrder.isPresent()){
            return new ResponseEntity<>(collectionOrder , HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhuma coleta no id informado", 404);
    }
    @Operation(summary = "Realiza a inserção de um Pedido de coleta na base de dados", method = "POST")
    @PostMapping
    public ResponseEntity<?> createCollectionOrder(@RequestBody CollectionOrder collectionOrder){
        if(collectionOrder != null){
            collectionOrderService.saveAndFlush(collectionOrder);
            return new ResponseEntity<>("Pedido de coleta criado com sucesso.", HttpStatus.CREATED);
        }
        throw new BadRequestException("Erro ao criar o Produto.", 400);
    }
    @Operation(summary = "Realiza a remoção de uma Ordem de coleta na base de dados a partir do seu identificador", method = "DELETE")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id){
        if (collectionOrderService.findById(id).isPresent()){
            collectionOrderService.delete(id);
            return new ResponseEntity<>("Ordem de coleta removida com sucesso.", HttpStatus.OK);
        }
        throw new BadRequestException("Erro ao deletar o produto.", 400);
    }
}
