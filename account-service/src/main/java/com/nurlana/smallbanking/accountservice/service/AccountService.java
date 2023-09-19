package com.nurlana.smallbanking.accountservice.service;

import com.nurlana.smallbanking.common.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {

    void createAccount(AccountDto accountDto);
    List<AccountDto> getAccountsByClientCode(String clientCode);

    AccountDto getAccountsByAccountNumber(String accountNumber);

}
