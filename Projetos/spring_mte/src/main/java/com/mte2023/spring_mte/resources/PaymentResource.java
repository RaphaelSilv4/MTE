package com.mte2023.spring_mte.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mte2023.spring_mte.entities.Payment;
import com.mte2023.spring_mte.exceptions_generic.BadRequestException;
import com.mte2023.spring_mte.services.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/payment", produces = "application/json;charset=UTF-8")
@Tag(name = "payment")
public class PaymentResource {
    @Autowired
    private PaymentService PaymentService;

    @Operation(summary = "Busca todos os pagamentos na base de dados", method = "GET")
    @GetMapping
    public ResponseEntity<?> getCollectionOrder(){
        List<Payment> paymentList = PaymentService.findAll();
        if (paymentList != null) {
            return new ResponseEntity<>(paymentList, HttpStatus.OK);
        }
        throw new BadRequestException("Nenhum pagamento cadastrado no banco", 404);
    }

    @Operation(summary = "Busca uma determinado pagamento na base de dados a partir de seu identificador", method = "GET")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCollectionOrderById(@PathVariable Integer id){
        Optional<Payment> collectionOrder = PaymentService.findById(id);
        if (collectionOrder.isPresent()){
            return new ResponseEntity<>(collectionOrder , HttpStatus.OK);
        }
        throw new BadRequestException("Não foi encontrado nenhum pagamento no id informado", 404);
    }
    @Operation(summary = "Realiza a inserção de um pagamento na base de dados", method = "POST")
    @PostMapping
    public ResponseEntity<?> createCollectionOrder(@RequestBody Payment payment){
        if(payment != null){
            PaymentService.saveAndFlush(payment);
            return new ResponseEntity<>("Pagamento realizado com sucesso.", HttpStatus.CREATED);
        }
        throw new BadRequestException("Erro ao executar o Pagamento.", 400);
    }
}