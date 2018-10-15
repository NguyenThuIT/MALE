package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.OrderDTO;
import com.machinelearning.demo.api.mapper.OrderMapper;
import com.machinelearning.demo.domain.Order;
import com.machinelearning.demo.repository.OrderRepository;
import com.machinelearning.demo.repository.ProductRepository;
import com.machinelearning.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
    }

    @Override
    public Set<OrderDTO> getAllOrder() {
        return orderRepository.findAll().stream().map(orderMapper::orderToOrderDTO).collect(Collectors.toSet());
    }
}
