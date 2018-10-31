package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.api.mapper.Order1Mapper;
import com.machinelearning.demo.repository.Order1Repository;
import com.machinelearning.demo.repository.ProductRepository;
import com.machinelearning.demo.service.Order1Service;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Order1ServiceImpl implements Order1Service {

    private final Order1Repository orderRepository;
    private final Order1Mapper orderMapper;
    private final ProductRepository productRepository;

    public Order1ServiceImpl(Order1Repository order1Repository, Order1Mapper orderMapper, ProductRepository productRepository) {
        this.orderRepository = order1Repository;
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
    }

    @Override
    public Set<Order1DTO> getAllOrder() {
        return orderRepository.findAll().stream().map(orderMapper::orderToOrder1DTO).collect(Collectors.toSet());
    }
}
