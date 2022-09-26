package com.dsevoluction.sales.controllers;

import com.dsevoluction.sales.entities.Order;
import com.dsevoluction.sales.entities.dtos.OrderDTO;
import com.dsevoluction.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody OrderDTO dto){
        Order order = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order.getId());
    }
}
