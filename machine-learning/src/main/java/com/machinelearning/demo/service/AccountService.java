package com.machinelearning.demo.service;

import com.machinelearning.demo.api.dto.created.AccountCreatedDTO;
import com.machinelearning.demo.api.dto.AccountDTO;
import com.machinelearning.demo.api.dto.updated.AccountUpdatedDTO;
import javafx.scene.effect.SepiaTone;

import java.util.List;
import java.util.Set;

public interface AccountService {

    Set<AccountDTO> getAllAccount(AccountDTO accountDTO);

    AccountDTO addAccount(AccountCreatedDTO accountCreatedDTO);
}
