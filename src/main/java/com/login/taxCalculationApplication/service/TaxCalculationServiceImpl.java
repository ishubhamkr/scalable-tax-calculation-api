package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.entity.OldTaxRegimeData;
import com.login.taxCalculationApplication.model.UserTaxData;
import com.login.taxCalculationApplication.repository.OldTaxRegimeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculationServiceImpl implements TaxCalculationService {

    @Autowired
    private OldTaxRegimeDataRepository oldTaxRegimeDataRepo;

    @Override
    public double calculateTax(UserTaxData userTaxData) {
        double totalTaxableIncome = calculateTotalTaxableIncome(userTaxData);
        double totalDeductions = calculateTotalDeductions(userTaxData);
        double netTaxableIncome = totalTaxableIncome - totalDeductions;

        double taxAmount = calculateTaxAmount(netTaxableIncome);

        // Save the data
        saveTaxData(userTaxData, taxAmount);

        return taxAmount;
    }

    private double calculateTotalTaxableIncome(UserTaxData userTaxData) {
        return userTaxData.getBasicSalary() + userTaxData.getAllowances() + userTaxData.getBonuses()
                + userTaxData.getRentalIncome() + userTaxData.getProfitLoss() + userTaxData.getInterestIncome()
                + userTaxData.getDividendIncome() + userTaxData.getWinnings();
    }

    private double calculateTotalDeductions(UserTaxData userTaxData) {
        return userTaxData.getInvestments() + userTaxData.getPremiums() + userTaxData.getHealthInsurancePremiums()
                + userTaxData.getEducationLoanInterest() + userTaxData.getHraReceived()
                + userTaxData.getStandardDeductionAmount();
    }

    private double calculateTaxAmount(double taxableIncome) {
        double taxAmount = 0.0;

        if (taxableIncome <= 250000) {
            // No tax for income up to 2.5 lakhs
            taxAmount = 0.0;
        } else if (taxableIncome > 250000 && taxableIncome <= 500000) {
            // 5% tax for income between 2.5 lakhs to 5 lakhs
            taxAmount = (taxableIncome - 250000) * 0.05;
        } else if (taxableIncome > 500000 && taxableIncome <= 1000000) {
            // 20% tax for income between 5 lakhs to 10 lakhs
            taxAmount = 12500 + (taxableIncome - 500000) * 0.2;
        } else {
            // 30% tax for income above 10 lakhs
            taxAmount = 112500 + (taxableIncome - 1000000) * 0.3;
        }

        return taxAmount;
    }

    private void saveTaxData(UserTaxData userTaxData, double taxAmount) {
        OldTaxRegimeData oldTaxRegimeData = new OldTaxRegimeData();
        oldTaxRegimeData.setEmail(userTaxData.getEmail());
        oldTaxRegimeData.setBasicSalary(userTaxData.getBasicSalary());
        oldTaxRegimeData.setAllowances(userTaxData.getAllowances());
        oldTaxRegimeData.setBonuses(userTaxData.getBonuses());
        oldTaxRegimeData.setRentalIncome(userTaxData.getRentalIncome());
        oldTaxRegimeData.setProfitLoss(userTaxData.getProfitLoss());
        oldTaxRegimeData.setInterestIncome(userTaxData.getInterestIncome());
        oldTaxRegimeData.setDividendIncome(userTaxData.getDividendIncome());
        oldTaxRegimeData.setWinnings(userTaxData.getWinnings());
        oldTaxRegimeData.setInvestments(userTaxData.getInvestments());
        oldTaxRegimeData.setPremiums(userTaxData.getPremiums());
        oldTaxRegimeData.setHealthInsurancePremiums(userTaxData.getHealthInsurancePremiums());
        oldTaxRegimeData.setEducationLoanInterest(userTaxData.getEducationLoanInterest());
        oldTaxRegimeData.setHraReceived(userTaxData.getHraReceived());
        oldTaxRegimeData.setStandardDeductionAmount(userTaxData.getStandardDeductionAmount());
        // Set tax amount calculated
        oldTaxRegimeData.setTaxAmount(taxAmount);

        // Save the entity
        oldTaxRegimeDataRepo.save(oldTaxRegimeData);
    }
}
