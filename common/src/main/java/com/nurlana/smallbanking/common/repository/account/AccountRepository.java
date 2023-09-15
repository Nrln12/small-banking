package com.nurlana.smallbanking.common.repository.account;

import com.nurlana.smallbanking.common.entity.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAccountsByClientCode(String clientCode);

    Optional<Account> findByAccountNumberAndClientCode(String accountNumber, String clientCode);
    Optional<Account> findByAccountNumber(String accountNumber);
}
