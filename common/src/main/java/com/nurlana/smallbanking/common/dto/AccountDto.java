package com.nurlana.smallbanking.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;


@Data
public class AccountDto {

    private Long id;

    private String name;

    private String surName;

    private String email;

    private String password;

    private String accountNumber;

    private String clientCode;

    private Double balance;

    private Date birthdate;

    private String gsmNumber;

}
