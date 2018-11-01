package com.machinelearning.demo.repository;

import com.machinelearning.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findByUsername(String accountUsername);

}
