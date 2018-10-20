package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.api.dto.AccountDTO;
import com.machinelearning.demo.api.dto.updated.AccountUpdatedDTO;
import com.machinelearning.demo.api.mapper.AccountMapper;
import com.machinelearning.demo.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    @Override
    public AccountDTO accountToAccountDTO(Account account) {
        if (account == null) return null;
        else {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setUsername(account.getUsername());
            accountDTO.setPassword(account.getPassword());
            accountDTO.setCustomer(account.getCustomer());
            return accountDTO;
        }
    }

    @Override
    public Account accountCreatedDTOToAccount(AccountCreatedDTO accountCreatedDTO) {
        if (accountCreatedDTO == null) return null;
        else {
            Account account = new Account();
            account.setUsername(account.getUsername());
            account.setPassword(account.getPassword());
            return account;
        }
    }
}
