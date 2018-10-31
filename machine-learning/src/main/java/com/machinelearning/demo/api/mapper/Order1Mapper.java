package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.Order1DTO;
import com.machinelearning.demo.domain.Order1;

public interface Order1Mapper {

    Order1DTO orderToOrder1DTO(Order1 order);
}
