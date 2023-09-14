package com.nurlana.smallbanking.customerservice.service.impl;

import com.nurlana.smallbanking.customerservice.entity.Customer;
import com.nurlana.smallbanking.customerservice.repository.CustomerRepository;
import com.nurlana.smallbanking.customerservice.request.CustomerRegistrationRequest;
import com.nurlana.smallbanking.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ANAzizli
 * @Date 03/06/2023
 */

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {

        if(request!=null
                && request.firstName()!=null
                && request.lastName()!=null
                && request.email()!=null
                && customerRepository.findByEmail(request.email()).isEmpty()
        ){

            // todo: check if email is valid

            Customer customer = Customer.builder()
                    .firstName(request.firstName())
                    .lastName(request.lastName())
                    .email(request.email())
                    .build();

            customer = customerRepository.saveAndFlush(customer);
            log.info("successfully added new customer: {}", customer);
        } else
            log.warn("we cant add new user for the some reasons: " +
                    "your email added in pass " +
                    "or your request not required format");

    }

}
