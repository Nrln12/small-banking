package com.nurlana.smallbanking.operationservice.service.impl;

import com.nurlana.smallbanking.common.entity.account.Account;
import com.nurlana.smallbanking.common.entity.operation.Operation;
import com.nurlana.smallbanking.common.enums.Status;
import com.nurlana.smallbanking.common.enums.TransactionType;
import com.nurlana.smallbanking.common.exception.BadRequestException;
import com.nurlana.smallbanking.common.exception.NotFoundException;
import com.nurlana.smallbanking.common.payload.OperationPayload;
import com.nurlana.smallbanking.common.repository.account.AccountRepository;
import com.nurlana.smallbanking.common.repository.operation.OperationRepository;
import com.nurlana.smallbanking.operationservice.service.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperationServiceImpl implements OperationService {

    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    @Override
    @Transactional
    public void createTopUpTransaction(OperationPayload payload) {
        Account account = accountRepository
                .findByAccountNumberAndClientCode(payload.getAccountNumber(), payload.getClientCode())
                .orElseThrow(() -> new NotFoundException("account not found"));
        Operation operation = new Operation();
        operation.setAmount(payload.getAmount());
        operation.setTransactionNumber(UUID.randomUUID().toString());
        operation.setClientCode(account.getClientCode());
        operation.setTransactionType(TransactionType.TOPUP);
        operation = operationRepository.save(operation);
        log.info("created new operation {}", operation);
        if(operation.getId()!=null){
            account.setBalance(account.getBalance()+payload.getAmount());
            accountRepository.save(account);
        }
        log.info("changed account {}", account);

    }

    @Override
    @Transactional
    public void createPurchaseTransaction(OperationPayload payload) {
        Account account = accountRepository
                .findByAccountNumberAndClientCode(payload.getAccountNumber(), payload.getClientCode())
                .orElseThrow(() -> new NotFoundException("account not found"));
        if(account.getBalance()<= payload.getAmount())
            throw new BadRequestException("Invalid transaction");
        Operation operation = new Operation();
        operation.setAmount(payload.getAmount());
        operation.setTransactionNumber(UUID.randomUUID().toString());
        operation.setTransactionType(TransactionType.PURCHASE);
        operation.setClientCode(account.getClientCode());
        operation = operationRepository.save(operation);
        log.info("created new operation {}", operation);
        if(operation.getId()!=null){
            account.setBalance(account.getBalance()-payload.getAmount());
            accountRepository.save(account);
        }
        log.info("changed account {}", account);
    }

    @Override
    @Transactional
    public void refundTransaction(String transactionNumber, OperationPayload payload) {
        Operation findOperation = operationRepository
                .findByTransactionNumber(transactionNumber)
                .orElseThrow(() -> new NotFoundException("Operation has not found"));
        Account account = accountRepository
                .findByAccountNumberAndClientCode(payload.getAccountNumber(), payload.getClientCode())
                .orElseThrow(() -> new NotFoundException("account not found"));
        if(findOperation.getAmount()<=payload.getAmount()){
            throw new BadRequestException("Invalid refund operation");
        }
        account.setBalance(account.getBalance()+payload.getAmount());
        accountRepository.save(account);
        Operation operation = new Operation();
        operation.setAmount(payload.getAmount());
        operation.setClientCode(payload.getClientCode());
        operation.setTransactionNumber(transactionNumber);
        operation.setTransactionType(TransactionType.REFUND);
        operation.setTransactionDate(LocalDateTime.now());
        operation.setStatus(Status.SUCCESS);
        operationRepository.save(operation);
    }
}
