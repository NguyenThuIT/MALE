package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.api.dto.created.CustomerCreatedDTO;
import com.machinelearning.demo.api.dto.updated.CustomerUpdateDTO;
import com.machinelearning.demo.domain.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Set<CustomerDTO> getAllCustomer();

    CustomerDTO addCustomer(CustomerCreatedDTO customerCreatedDTO);

    CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getSingleCustomer(Integer customerId);
}
