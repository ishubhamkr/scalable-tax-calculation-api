package com.login.usermanagement.service;

import com.login.usermanagement.model.UserTaxData;

public interface TaxCalculationService {
    double calculateTax(UserTaxData userTaxData);
}
