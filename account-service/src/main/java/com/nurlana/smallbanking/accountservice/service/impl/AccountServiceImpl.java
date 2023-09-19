package com.nurlana.smallbanking.accountservice.service.impl;

import com.nurlana.smallbanking.accountservice.service.AccountService;
import com.nurlana.smallbanking.common.dto.AccountDto;
import com.nurlana.smallbanking.common.entity.account.Account;
import com.nurlana.smallbanking.common.exception.NotFoundException;
import com.nurlana.smallbanking.common.repository.account.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public void createAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(accountDto.getBalance());
    }

    @Override
    public List<AccountDto> getAccountsByClientCode(String clientCode) {
        return accountRepository.findAccountsByClientCode(clientCode)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public AccountDto getAccountsByAccountNumber(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new NotFoundException("Account not found"));
        return this.convertToDto(account);
    }

    private AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setClientCode(account.getClientCode());
        return accountDto;
    }

}
