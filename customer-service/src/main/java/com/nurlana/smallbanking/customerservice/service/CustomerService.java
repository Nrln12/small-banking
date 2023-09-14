package com.nurlana.smallbanking.customerservice.service;

import com.nurlana.smallbanking.customerservice.request.CustomerRegistrationRequest;

/**
 * @author ANAzizli
 * @Date 03/06/2023
 */
public interface CustomerService {

    void registerCustomer(CustomerRegistrationRequest request);

}
