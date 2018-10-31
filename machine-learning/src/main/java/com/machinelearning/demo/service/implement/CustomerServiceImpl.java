package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.api.dto.created.CustomerCreatedDTO;
import com.machinelearning.demo.api.dto.updated.CustomerUpdateDTO;
import com.machinelearning.demo.api.mapper.CustomerMapper;
import com.machinelearning.demo.domain.Customer;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.CustomerRepository;
import com.machinelearning.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Set<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public CustomerDTO addCustomer(CustomerCreatedDTO customerCreatedDTO) {
        Customer saveCustomer = customerRepository.save(customerMapper.customerCreatedDTOToCustomer(customerCreatedDTO));
        return customerMapper.customerToCustomerDTO(saveCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerUpdateDTO.getId());
        if (!optionalCustomer.isPresent()){
            throw new ResourceNotFoundException("Customer " + customerUpdateDTO.getId() +" not found");
        }
        Customer customer = optionalCustomer.get();
        if (customerUpdateDTO.getName() != null) {
            customer.setName(customerUpdateDTO.getName());
        }
        if (customerUpdateDTO.getPhone() != null) {
            customer.setPhone(customerUpdateDTO.getPhone());
        }
        if (customerUpdateDTO.getEmail() != null) {
            customer.setEmail(customerUpdateDTO.getEmail());
        }
        if (customerUpdateDTO.getAccount() != null) {
            customer.setAccount(customerUpdateDTO.getAccount());
        }

        Customer saveCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(saveCustomer);
    }
}
