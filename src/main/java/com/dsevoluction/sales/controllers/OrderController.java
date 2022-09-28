package com.dsevoluction.sales.controllers;

import com.dsevoluction.sales.entities.Order;
import com.dsevoluction.sales.entities.dtos.OrderDTO;
import com.dsevoluction.sales.entities.enums.OrderStatus;
import com.dsevoluction.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody OrderDTO dto){
        Order order = service.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order.getId());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getById (@PathVariable Integer id ){
        Order order = service.informationOrder(id);
        return ResponseEntity.ok().body(order);
    }

    @PatchMapping(value = "/{id}")
   public ResponseEntity<Void> upDateStatus(@PathVariable Integer id, @RequestBody Order order){
        service.upDate(id, order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
