package com.login.taxCalculationApplication.model;

import lombok.Data;

@Data
public class UserTaxData {
    private String email;
    private double basicSalary;
    private double allowances;
    private double bonuses;
    private double rentalIncome;
    private double profitLoss;
    private double interestIncome;
    private double dividendIncome;
    private double winnings;
    private double investments;
    private double premiums;
    private double healthInsurancePremiums;
    private double educationLoanInterest;
    private double hraReceived;
    private double standardDeductionAmount;
}
