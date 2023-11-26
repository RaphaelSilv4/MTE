package com.mte2023.spring_mte.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mte2023.spring_mte.services.PaymentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/payment", produces = "application/json;charset=UTF-8")
@Tag(name = "payment")
public class PaymentResource {
    @Autowired
    private PaymentService PaymentService;
}
