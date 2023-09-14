package com.nurlana.smallbanking.customerservice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author ANAzizli
 * @Date 03/27/2023
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence")
    @GeneratedValue(
            generator = "customer_id_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
