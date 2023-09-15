package com.nurlana.smallbanking.operationservice.controller;


import com.nurlana.smallbanking.common.payload.OperationPayload;
import com.nurlana.smallbanking.operationservice.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operations")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService transactionService;

    @PostMapping("/top-up")
    public ResponseEntity<?> createTopUpTransaction(@RequestBody OperationPayload payload){
        transactionService.createTopUpTransaction(payload);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/purchase/")
    public ResponseEntity<?> createPurchaseTransaction(@RequestBody OperationPayload payload){
        transactionService.createPurchaseTransaction(payload);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/refund/{transaction-number}")
    public ResponseEntity<?> refundTransaction(@PathVariable String transactionNumber, @RequestBody OperationPayload payload){
        transactionService.refundTransaction(transactionNumber,payload);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
