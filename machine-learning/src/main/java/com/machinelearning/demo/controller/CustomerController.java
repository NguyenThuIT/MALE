package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.api.dto.created.CustomerCreatedDTO;
import com.machinelearning.demo.api.dto.updated.CustomerUpdateDTO;
import com.machinelearning.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO addCustomer(@RequestBody CustomerCreatedDTO customerCreatedDTO){
        return customerService.addCustomer(customerCreatedDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        return customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getSingleCustomer(@PathVariable("id") Integer customerId){
        return customerService.getSingleCustomer(customerId);
    }
}
