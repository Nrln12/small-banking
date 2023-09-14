package com.nurlana.smallbanking.common.repository;

import com.nurlana.smallbanking.common.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByGsmNumber(String number);
}
