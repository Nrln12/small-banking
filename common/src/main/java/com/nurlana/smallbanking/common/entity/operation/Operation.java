package com.nurlana.smallbanking.common.entity.operation;


import com.nurlana.smallbanking.common.entity.BaseEntity;
import com.nurlana.smallbanking.common.enums.Status;
import com.nurlana.smallbanking.common.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Operation extends BaseEntity {

    @Id
    @SequenceGenerator(name = "transactions_seq_generator",
            sequenceName = "transactions_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_seq_generator")
    private Long id;

    private String clientCode;

    private String transactionNumber;

    private LocalDateTime transactionDate;

    private Double amount;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(value = EnumType.STRING)
    private Status status;

}
