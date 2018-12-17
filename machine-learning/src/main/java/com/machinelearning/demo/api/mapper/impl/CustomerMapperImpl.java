package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.api.dto.created.CustomerCreatedDTO;
import com.machinelearning.demo.api.mapper.CustomerMapper;
import com.machinelearning.demo.api.mapper.Order1Mapper;
import com.machinelearning.demo.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    private final Order1Mapper order1Mapper;

    public CustomerMapperImpl(Order1Mapper order1Mapper) {
        this.order1Mapper = order1Mapper;
    }

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if (customer == null) return null;
        else {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setPhone(customer.getPhone());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setAccountUsername(customer.getAccount().getUsername());
            customerDTO.setOrder(customer.getOrders()
                    .stream()
                    .map(order1Mapper::orderToOrder1DTO)
                    .collect(Collectors.toSet()));
            return customerDTO;
        }
    }

    @Override
    public Customer customerCreatedDTOToCustomer(CustomerCreatedDTO customerCreatedDTO) {
        if (customerCreatedDTO == null) return null;
        else {
            Customer customer = new Customer();
            customer.setName(customerCreatedDTO.getName());
            customer.setPhone(customerCreatedDTO.getPhone());
            customer.setEmail(customerCreatedDTO.getEmail());
            customer.setAccount(customerCreatedDTO.getAccount());
            return customer;
        }
    }
}
