package com.microservices.order.controller;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromClient;
import com.microservices.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromClient orderDetails){
        OrderDTO orderDTO = orderService.saveOrderDetailsInDB(orderDetails);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
