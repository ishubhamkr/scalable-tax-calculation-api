package com.login.taxCalculationApplication.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TaxData")
@Data
public class OldTaxRegimeData {
    @Id
    private Long id;
    private String email;
    private double basicSalary;
    private double allowances;
    private double bonuses;
    private double rentalIncome;
    private double municipalTaxes;
    private double standardDeductions;
    private double profitLoss;
    private double expenses;
    private double deductions;
    private double capitalGains;
    private String assetDetails;
    private double interestIncome;
    private double dividendIncome;
    private double winnings;
    private double investments;
    private double premiums;
    private double healthInsurancePremiums;
    private double educationLoanInterest;
    private double hraReceived;
    private String hraConditions;
    private double standardDeductionAmount;
    private double taxSlab1Rate;
    private double taxSlab1Limit;
    private double taxSlab2Rate;
    private double taxSlab2Limit;
    private double taxSlab3Rate;
    private double taxSlab3Limit;
    private double taxSlab4Rate;
}
