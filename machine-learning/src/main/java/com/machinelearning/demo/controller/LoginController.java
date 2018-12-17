package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.LoginDTO;
import com.machinelearning.demo.api.dto.LoginResultDTO;
import com.machinelearning.demo.service.LoginSevice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RequestMapping("/login")
@RestController
public class LoginController {
    private final LoginSevice loginSevice;

    public LoginController(LoginSevice loginSevice) {
        this.loginSevice = loginSevice;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public LoginResultDTO getLogin(@RequestBody LoginDTO loginDTO){
        return loginSevice.login(loginDTO);
    }
}
