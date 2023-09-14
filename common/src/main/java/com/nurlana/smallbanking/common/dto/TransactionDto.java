package com.nurlana.smallbanking.common.dto;

import com.nurlana.smallbanking.common.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private LocalDateTime transactionDate;
    private Double amount;
    private Status status;
}
