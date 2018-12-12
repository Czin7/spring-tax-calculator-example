package com.wp.taxes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
public class TaxComputationParameters {
    @Getter private final BigDecimal taxRate;
    @Getter private final BigDecimal amountToBeTaxed;
    @Getter private final String taxTypeFromDb;
}
