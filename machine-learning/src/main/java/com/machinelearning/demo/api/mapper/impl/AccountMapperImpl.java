package com.machinelearning.demo.api.mapper.impl;

import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.api.dto.AccountDTO;
import com.machinelearning.demo.api.mapper.AccountMapper;
import com.machinelearning.demo.api.mapper.RatingMapper;
import com.machinelearning.demo.domain.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountMapperImpl implements AccountMapper {

    private final RatingMapper ratingMapper;

    public AccountMapperImpl(RatingMapper ratingMapper) {
        this.ratingMapper = ratingMapper;
    }

    @Override
    public AccountDTO accountToAccountDTO(Account account) {
        if (account == null) return null;
        else {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setUsername(account.getUsername());
            accountDTO.setPassword(account.getPassword());
            accountDTO.setRating(account.getRatings()
                    .stream().map(ratingMapper::ratingToRatingDTO)
                    .collect(Collectors.toSet()));
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
