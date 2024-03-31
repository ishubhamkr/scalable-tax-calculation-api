package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.model.UserTaxData;

public interface TaxCalculationService {
    double calculateTax(UserTaxData userTaxData);
}
