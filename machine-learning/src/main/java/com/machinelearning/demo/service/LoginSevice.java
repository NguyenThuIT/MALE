package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.LoginDTO;
import com.machinelearning.demo.api.dto.LoginResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginSevice {
    LoginResultDTO login(LoginDTO loginDTO);
}
