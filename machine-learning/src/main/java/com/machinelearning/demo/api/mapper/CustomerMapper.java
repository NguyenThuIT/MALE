package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.api.dto.created.CustomerCreatedDTO;
import com.machinelearning.demo.api.dto.updated.CustomerUpdateDTO;
import com.machinelearning.demo.domain.Customer;

public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerCreatedDTOToCustomer(CustomerCreatedDTO customerCreatedDTO);
}
