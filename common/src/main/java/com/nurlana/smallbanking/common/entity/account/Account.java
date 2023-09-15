package com.nurlana.smallbanking.common.entity.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nurlana.smallbanking.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Account extends BaseEntity {

    @Id
    @SequenceGenerator(name = "accounts_seq_generator",
            sequenceName = "accounts_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_seq_generator")
    private Long id;

    private String accountNumber;

    private String clientCode;

    private Double balance;

    private String name;

    private String surName;


    @Column(unique = true)
    private String email;

    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;

    private String gsmNumber;

}
