package com.nurlana.smallbanking.common.payload;

import com.nurlana.smallbanking.common.enums.TransactionType;
import lombok.Data;

@Data
public class OperationPayload {
    private String clientCode;
    private String accountNumber;
    private Double amount;
    private TransactionType type;
}
