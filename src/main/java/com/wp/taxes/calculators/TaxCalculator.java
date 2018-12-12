package com.wp.taxes.calculators;

import com.wp.taxes.models.TaxComputationParameters;

import java.math.BigDecimal;

public interface TaxCalculator<T extends TaxComputationParameters, R extends BigDecimal> {
    public R calculate(T computationData);
}
