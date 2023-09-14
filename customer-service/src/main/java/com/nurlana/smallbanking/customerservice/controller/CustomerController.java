package com.nurlana.smallbanking.customerservice.controller;

import com.nurlana.smallbanking.customerservice.request.CustomerRegistrationRequest;
import com.nurlana.smallbanking.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ANAzizli
 * @Date 03/06/2023
 */

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registrationCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){

        log.info("new customer request: {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);

    }

}
