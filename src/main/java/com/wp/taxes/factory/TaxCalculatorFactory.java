package com.wp.taxes.factory;

import com.wp.taxes.calculators.BasicTaxCalculator;
import com.wp.taxes.calculators.CustomTaxCalculator;
import com.wp.taxes.calculators.TaxCalculator;
import com.wp.taxes.models.TaxType;
import com.wp.taxes.resolvers.TaxTypeResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TaxCalculatorFactory {
    private final TaxTypeResolver taxLevelResolver;
    private final BasicTaxCalculator basicTaxCalculator;
    private final CustomTaxCalculator customTaxCalculator;

    public TaxCalculator create(String taxTypeFromDb){
        TaxType taxLevel = taxLevelResolver.resolve(taxTypeFromDb);
        if(TaxType.BASIC.equals(taxLevel)) return basicTaxCalculator;
        return customTaxCalculator;
    }
}
