package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.service.Order1Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/order")
@RestController
public class Order1Controller {

    private final Order1Service order1Service;

    public Order1Controller(Order1Service order1Service) {
        this.order1Service = order1Service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<Order1DTO> getAllOrder1(){
        return order1Service.getAllOrder();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order1DTO getSingleOrder(@PathVariable("id") Integer orderId){
        return order1Service.getSingleOrder(orderId);
    }
}
