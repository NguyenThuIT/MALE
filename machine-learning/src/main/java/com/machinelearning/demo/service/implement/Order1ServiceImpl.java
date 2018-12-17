package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.api.dto.created.OrderCreatedDTO;
import com.machinelearning.demo.api.mapper.ItemMapper;
import com.machinelearning.demo.api.mapper.Order1Mapper;
import com.machinelearning.demo.domain.Customer;
import com.machinelearning.demo.domain.Item;
import com.machinelearning.demo.domain.Order1;
import com.machinelearning.demo.exception.RelatedResourceException;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.CustomerRepository;
import com.machinelearning.demo.repository.ItemRepository;
import com.machinelearning.demo.repository.Order1Repository;
import com.machinelearning.demo.service.Order1Service;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Order1ServiceImpl implements Order1Service {

    private final Order1Repository order1Repository;
    private final Order1Mapper order1Mapper;
    private final CustomerRepository customerRepository;
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    public Order1ServiceImpl(Order1Repository order1Repository, Order1Mapper orderMapper, CustomerRepository customerRepository, ItemMapper itemMapper, ItemRepository itemRepository) {
        this.order1Repository = order1Repository;
        this.order1Mapper = orderMapper;
        this.customerRepository = customerRepository;
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public Set<Order1DTO> getAllOrder() {
        return order1Repository.findAll().stream().map(order1Mapper::orderToOrder1DTO).collect(Collectors.toSet());
    }

    @Override
    public Order1DTO getSingleOrder(Integer orderId) {
        Optional<Order1> optionalOrder1 = order1Repository.findById(orderId);
        if (optionalOrder1.isPresent()) {
            return order1Mapper.orderToOrder1DTO(optionalOrder1.get());
        } else {
            throw new ResourceNotFoundException("Order " + orderId + " not found");
        }
    }

    @Override
    public Order1DTO addOrder(OrderCreatedDTO orderCreatedDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(orderCreatedDTO.getCustomerId());
        if (optionalCustomer.isPresent()) {
            Customer foundCustomer = optionalCustomer.get();

            Order1 order1 = new Order1();
            order1.setDateCreated(orderCreatedDTO.getDateCreated());
            order1.setAmount(orderCreatedDTO.getAmountItem());
            order1.setPrice(orderCreatedDTO.getPrice());
            order1.setCustomer(foundCustomer);
            order1Repository.save(order1);

            foundCustomer.getOrders().add(order1);
            customerRepository.save(foundCustomer);

            return order1Mapper.orderToOrder1DTO(order1);
        } else {
            throw new ResourceNotFoundException("Customer " + orderCreatedDTO.getCustomerId() + " not found");
        }
    }

    @Override
    public Order1DTO updateOrder(Order1DTO order1DTO) {
        Optional<Order1> optionalOrder1 = order1Repository.findById(order1DTO.getId());
        if (!optionalOrder1.isPresent()) {
            return null;
        }
        Order1 order1 = optionalOrder1.get();
        if (order1DTO.getCustomerId() != null) {
            Customer customer = order1.getCustomer();
            customerRepository.save(customer.removeOrder(order1));

            Optional<Customer> optionalCustomer = customerRepository.findById(order1DTO.getCustomerId());
            if (optionalCustomer.isPresent()) {
                customerRepository.save(optionalCustomer.get().addOrder(order1));
                order1.setCustomer(optionalCustomer.get());
            }

        }
        if (order1DTO.getAmount() != order1.getAmount()) {
            order1.setAmount(order1DTO.getAmount());
        }

        if (order1DTO.getPrice() != order1.getPrice()) {
            order1.setPrice(order1DTO.getPrice());
        }

        if (order1DTO.getDateCreated() != null) {
            order1.setDateCreated(order1DTO.getDateCreated());
        }

        Order1 saveOrder = order1Repository.save(order1);
        return order1Mapper.orderToOrder1DTO(saveOrder);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Optional<Order1> optionalOrder1 = order1Repository.findById(orderId);
        if (!optionalOrder1.isPresent()) {
            throw new ResourceNotFoundException("Order " + orderId + " not found");
        } else {
            Order1 foundOrder = optionalOrder1.get();
            if (!foundOrder.getItems().isEmpty()) {
                throw new RelatedResourceException("Can not delete. " + foundOrder.getItems().size() + " item is contained");
            } else {
                Customer customer = optionalOrder1.get().getCustomer();
                customerRepository.save(customer.removeOrder(optionalOrder1.get()));
                order1Repository.delete(optionalOrder1.get());
                order1Repository.deleteById(orderId);
            }
        }
    }
}
