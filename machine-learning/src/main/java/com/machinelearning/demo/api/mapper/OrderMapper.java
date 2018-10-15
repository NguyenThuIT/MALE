package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.OrderDTO;
import com.machinelearning.demo.domain.Order;

public interface OrderMapper {

    OrderDTO orderToOrderDTO(Order order);
}
