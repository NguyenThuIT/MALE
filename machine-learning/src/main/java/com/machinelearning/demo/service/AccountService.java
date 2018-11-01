package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.api.dto.AccountDTO;

import java.util.List;
import java.util.Set;

public interface AccountService {

    Set<AccountDTO> getAllAccount();

    AccountDTO addAccount(AccountCreatedDTO accountCreatedDTO);

    AccountDTO getSingleAccount(String accountUsername);
}
