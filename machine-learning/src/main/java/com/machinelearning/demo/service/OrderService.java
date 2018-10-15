package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.OrderDTO;
import com.machinelearning.demo.domain.Order;
import org.aspectj.weaver.ast.Or;

import java.util.Set;

public interface OrderService {
    Set<OrderDTO> getAllOrder();
}
