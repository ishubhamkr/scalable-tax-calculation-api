package com.login.taxCalculationApplication.service;

import com.login.taxCalculationApplication.entity.OldTaxRegimeData;
import com.login.taxCalculationApplication.model.UserTaxData;
import com.login.taxCalculationApplication.repository.OldTaxRegimeDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculationServiceImplTest {

    @Mock
    private OldTaxRegimeDataRepository oldTaxRegimeDataRepository;

    @InjectMocks
    private TaxCalculationServiceImpl taxCalculationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void calculateTax_Success() {
        // Create a mock user tax data
        UserTaxData userTaxData = new UserTaxData();
        userTaxData.setEmail("test@example.com");
        userTaxData.setBasicSalary(500000);
        userTaxData.setAllowances(20000);
        userTaxData.setBonuses(10000);
        userTaxData.setRentalIncome(15000);
        userTaxData.setProfitLoss(20000);
        userTaxData.setInterestIncome(5000);
        userTaxData.setDividendIncome(3000);
        userTaxData.setWinnings(1000);
        userTaxData.setInvestments(20000);
        userTaxData.setPremiums(5000);
        userTaxData.setHealthInsurancePremiums(3000);
        userTaxData.setEducationLoanInterest(2000);
        userTaxData.setHraReceived(10000);
        userTaxData.setStandardDeductionAmount(10000);

        // Define the expected tax amount
        double expectedTaxAmount = 17300; // Correct expected tax amount based on the provided tax calculation logic

        // Call the calculateTax method
        double actualTaxAmount = taxCalculationService.calculateTax(userTaxData);

        // Verify that the saveTaxData method is called with the correct arguments
        verify(oldTaxRegimeDataRepository, times(1)).save(any(OldTaxRegimeData.class));

        // Assert that the actual tax amount matches the expected tax amount
        assertEquals(expectedTaxAmount, actualTaxAmount);
    }
}
