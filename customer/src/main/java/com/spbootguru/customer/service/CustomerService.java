package com.spbootguru.customer.service;

import org.springframework.stereotype.Service;

import com.spbootguru.customer.dao.CustomerRegistrationRequest;
import com.spbootguru.customer.model.Customer;
import com.spbootguru.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo check if email not taken
        // todo: store customer in db
        customerRepository.save(customer);
    }

}
