package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();

    CustomerDTO addCustomer();
}
