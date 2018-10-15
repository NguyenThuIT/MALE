package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.LoginDTO;
import com.machinelearning.demo.api.dto.LoginResultDTO;
import com.machinelearning.demo.domain.Account;
import com.machinelearning.demo.repository.AccountRepository;
import com.machinelearning.demo.service.LoginSevice;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginSevice {
    private final AccountRepository accountRepository;

    public LoginServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public LoginResultDTO login(LoginDTO loginDTO) {
        LoginResultDTO loginResultDTO = new LoginResultDTO();

        if (loginDTO.getUsername().isEmpty() && loginDTO.getPassword().isEmpty()) {
            loginResultDTO.setSuccessful(false);
            loginResultDTO.setMessage("Login Fail !");
            loginResultDTO.setUsername("Username is not existed");
            return loginResultDTO;
        } else {
            Account account =  accountRepository.findById(loginDTO.getUsername()).get();
            if(account.getPassword().equals(loginDTO.getPassword())){
                loginResultDTO.setSuccessful(true);
                loginResultDTO.setMessage("Login Successful !");
                loginResultDTO.setUsername(loginDTO.getUsername());
                return loginResultDTO;
            }
            else {
                loginResultDTO.setSuccessful(false);
                loginResultDTO.setMessage("Login Fail !");
                loginResultDTO.setUsername("password is not correct");
                return loginResultDTO;

            }

        }
    }
}
