package com.machinelearning.demo.controller;

import com.machinelearning.demo.api.dto.AccountDTO;
import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.domain.Account;
import com.machinelearning.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<AccountDTO> getAllAccount(){
        return accountService.getAllAccount();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO addAccount(@RequestBody AccountCreatedDTO accountCreatedDTO){
        return accountService.addAccount(accountCreatedDTO);
    }
}
