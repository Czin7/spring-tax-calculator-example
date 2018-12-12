package com.wp.taxes.services;

import com.wp.taxes.calculators.TaxCalculator;
import com.wp.taxes.factory.TaxCalculatorFactory;
import com.wp.taxes.models.TaxComputationParameters;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class TaxService {
    private TaxCalculatorFactory taxCalculatorFactory;

    public BigDecimal performTaxCalculations(TaxComputationParameters taxComputationParameters){
        TaxCalculator defaultCalculator = taxCalculatorFactory.create(taxComputationParameters.getTaxTypeFromDb());
        return defaultCalculator.calculate(taxComputationParameters);
    }
}
