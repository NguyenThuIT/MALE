package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.CustomerDTO;
import com.machinelearning.demo.api.dto.created.CustomerCreatedDTO;
import com.machinelearning.demo.api.dto.updated.CustomerUpdateDTO;
import com.machinelearning.demo.api.mapper.CustomerMapper;
import com.machinelearning.demo.domain.Account;
import com.machinelearning.demo.domain.Customer;
import com.machinelearning.demo.domain.Order1;
import com.machinelearning.demo.exception.RelatedResourceException;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.AccountRepository;
import com.machinelearning.demo.repository.CustomerRepository;
import com.machinelearning.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AccountRepository accountRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.accountRepository = accountRepository;
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
        if (!optionalCustomer.isPresent()) {
            throw new ResourceNotFoundException("Customer " + customerUpdateDTO.getId() + " not found");
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

    @Override
    public CustomerDTO getSingleCustomer(Integer customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            return customerMapper.customerToCustomerDTO(optionalCustomer.get());
        } else {
            throw new ResourceNotFoundException("Customer " + customerId + " not found");
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (!optionalCustomer.isPresent()) {
            throw new ResourceNotFoundException("Customer " + customerId + " not found");
        } else {
            Customer foundCustomer = optionalCustomer.get();
            if (!foundCustomer.getOrders().isEmpty()) {
                throw new RelatedResourceException("Can not delete. " + foundCustomer.getOrders().size() + " order is contained");
            } else {
                customerRepository.deleteById(customerId);
            }
        }
    }
}
