package org.fraud.service;

import java.time.LocalDateTime;

import org.fraud.model.Fraud;
import org.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudService {

    @Autowired
    private final FraudCheckHistoryRepository fraudcheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
         fraudcheckHistoryRepository
                .save(
                        Fraud.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build());
         return false;
    }

}
