package com.machinelearning.demo.api.mapper;

import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.api.dto.AccountDTO;
import com.machinelearning.demo.api.dto.updated.AccountUpdatedDTO;
import com.machinelearning.demo.domain.Account;

public interface AccountMapper {
    AccountDTO accountToAccountDTO(Account account);

    Account accountCreatedDTOToAccount(AccountCreatedDTO accountCreatedDTO);
}
