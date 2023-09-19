package com.nurlana.smallbanking.accountservice.controller;


import com.nurlana.smallbanking.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @GetMapping
    public ResponseEntity<?> getClientAccounts(@RequestHeader String clientCode) {
        return ResponseEntity.ok(accountService.getAccountsByClientCode(clientCode));
    }

}
