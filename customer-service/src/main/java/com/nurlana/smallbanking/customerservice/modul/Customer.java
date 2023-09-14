package com.nurlana.smallbanking.customerservice.modul;

import lombok.Builder;
import lombok.Data;

/**
 * @author ANAzizli
 * @Date 03/06/2023
 */

@Data
@Builder
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
