package com.wp.taxes.calculators;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Component
public class TaxCalculationFunction {
    private final static BigDecimal BASE = new BigDecimal(100);

    public Function<BigDecimal, BigDecimal> get(BigDecimal taxPercentage){
            return amount -> amount.multiply(taxPercentage).divide(BASE);
    }
}
