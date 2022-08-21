package com.spbootguru.customer.service;

import java.nio.channels.IllegalSelectorException;

import org.fraud.response.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spbootguru.customer.dao.CustomerRegistrationRequest;
import com.spbootguru.customer.model.Customer;
import com.spbootguru.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate resttemplate;
    
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo check if email not taken
       
        // todo: store customer in db
        customerRepository.saveAndFlush(customer);
        
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = resttemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", 
                FraudCheckResponse.class,
                customer.getId());
        
        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
        // todo: send notification
    }

}
