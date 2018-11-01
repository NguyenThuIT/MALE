package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.api.mapper.ItemMapper;
import com.machinelearning.demo.api.mapper.Order1Mapper;
import com.machinelearning.demo.domain.Order1;
import com.machinelearning.demo.exception.ResourceNotFoundException;
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
    private final ItemMapper itemMapper;

    public Order1ServiceImpl(Order1Repository order1Repository, Order1Mapper orderMapper, ItemMapper itemMapper) {
        this.order1Repository = order1Repository;
        this.order1Mapper = orderMapper;
        this.itemMapper = itemMapper;
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
}
