package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.OrderDTO;
import com.machinelearning.demo.api.dto.ProductDTO;
import com.machinelearning.demo.api.mapper.OrderMapper;
import com.machinelearning.demo.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMappeImpl implements OrderMapper {
    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if (order == null) return null;
        else {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCustomer(order.getCustomer());
            orderDTO.setAmount(order.getAmount());
            orderDTO.setDateCreated(order.getDateCreated());
            orderDTO.setPrice(order.getPrice());
            return orderDTO;
        }
    }
}
