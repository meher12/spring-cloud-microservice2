package org.fraud.controller;

import org.fraud.response.FraudCheckResponse;
import org.fraud.service.FraudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudService fraudService;
    
    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
      boolean isFraudulentCustomer =   fraudService.isFraudulentCustomer(customerId);
      log.info("fraud check request for customer {}", customerId);
      return new FraudCheckResponse(isFraudulentCustomer);
    }

//    @GetMapping(path = "{customerId}")
//    public FraudCheckResponse isFraudster(
//            @PathVariable("customerId") Integer customerId) {
//        boolean isFraudulentCustomer = fraudService.
//                isFraudulentCustomer(customerId);
//        log.info("fraud check request for customer {}", customerId);
//
//        return new FraudCheckResponse(isFraudulentCustomer);
//    }
}