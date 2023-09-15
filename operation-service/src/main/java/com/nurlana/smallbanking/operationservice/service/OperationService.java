package com.nurlana.smallbanking.operationservice.service;

import com.nurlana.smallbanking.common.payload.OperationPayload;

public interface OperationService {

    void createTopUpTransaction(OperationPayload payload);

    void createPurchaseTransaction(OperationPayload payload);

    void refundTransaction(String transactionNumber, OperationPayload payload);

}
