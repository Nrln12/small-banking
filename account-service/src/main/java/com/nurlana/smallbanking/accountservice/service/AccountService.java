package com.nurlana.smallbanking.accountservice.service;

import com.nurlana.smallbanking.common.dto.AccountDto;

import java.util.List;

public interface AccountService {

    void createAccount(AccountDto accountDto);
    List<AccountDto> getAccountsByClientCode(String clientCode);

    AccountDto getAccountsByAccountNumber(String accountNumber);

}
