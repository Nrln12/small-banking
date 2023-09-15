package com.nurlana.smallbanking.common.repository.operation;

import com.nurlana.smallbanking.common.entity.operation.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findByTransactionNumber(String transactionNumber);

}
