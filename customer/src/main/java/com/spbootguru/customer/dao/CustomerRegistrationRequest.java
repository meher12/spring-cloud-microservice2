package com.spbootguru.customer.dao;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
