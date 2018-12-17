package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.api.dto.created.OrderCreatedDTO;

import java.util.Set;

public interface Order1Service {
    Set<Order1DTO> getAllOrder();

    Order1DTO getSingleOrder(Integer orderId);

    Order1DTO addOrder(OrderCreatedDTO orderCreatedDTO);

    Order1DTO updateOrder(Order1DTO order1DTO);

    void deleteOrder(Integer orderId);
}
