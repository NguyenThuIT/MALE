package com.machinelearning.demo.service.implement;


import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.api.dto.AccountDTO;
import com.machinelearning.demo.api.dto.updated.AccountUpdatedDTO;
import com.machinelearning.demo.api.mapper.AccountMapper;
import com.machinelearning.demo.domain.Account;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.AccountRepository;
import com.machinelearning.demo.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Set<AccountDTO> getAllAccount() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::accountToAccountDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public AccountDTO addAccount(AccountCreatedDTO accountCreatedDTO) {
        Account saveAccount = accountRepository.save(accountMapper.accountCreatedDTOToAccount(accountCreatedDTO));
        return accountMapper.accountToAccountDTO(saveAccount);
    }

    @Override
    public AccountDTO getSingleAccount(String accountUsername) {
        Optional<Account> optionalAccount = accountRepository.findByUsername(accountUsername);
        if (optionalAccount.isPresent()){
            return accountMapper.accountToAccountDTO(optionalAccount.get());
        }
        else {
            throw new ResourceNotFoundException("Account " + accountUsername + " not found");
        }

    }
}
