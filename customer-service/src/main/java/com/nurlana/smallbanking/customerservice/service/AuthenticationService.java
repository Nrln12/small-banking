package com.nurlana.smallbanking.customerservice.service;


import com.nurlana.smallbanking.common.request.SigninRequest;
import com.nurlana.smallbanking.common.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse signin(SigninRequest request);
}
