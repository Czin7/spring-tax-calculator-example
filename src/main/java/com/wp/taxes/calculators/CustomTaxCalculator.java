package com.wp.taxes.calculators;

import com.wp.taxes.models.TaxComputationParameters;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomTaxCalculator implements TaxCalculator<TaxComputationParameters, BigDecimal> {
    private final TaxCalculationFunction taxCalculationFunction;

    @Override
    public BigDecimal calculate(TaxComputationParameters computationData) {
        Function<BigDecimal, BigDecimal> function = taxCalculationFunction.get(computationData.getTaxRate());
        return function.apply(computationData.getAmountToBeTaxed()).divide(BigDecimal.TEN);
    }
}