package com.login.usermanagement.controller;

import com.login.usermanagement.model.UserTaxData;
import com.login.usermanagement.service.TaxCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {

    @Autowired
    private TaxCalculationService taxCalculationService;

    @PostMapping(value = "/scalableTaxCalculation/tax/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> calculateTax(@RequestBody UserTaxData userTaxData) {
        try {
            double taxAmount = taxCalculationService.calculateTax(userTaxData);
            return ResponseEntity.ok().body(taxAmount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while calculating tax");
        }
    }
}

