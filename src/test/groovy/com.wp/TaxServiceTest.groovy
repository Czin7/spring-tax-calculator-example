package com.wp

import com.wp.taxes.models.TaxComputationParameters
import com.wp.taxes.services.TaxService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = SpringTaxExampleApplication.class)
class TaxServiceTest extends Specification {

    @Autowired
    TaxService taxService

    def "Basic tax should be correctly calculated."() {
        given:
            def taxComputationParameters = new TaxComputationParameters(BigDecimal.valueOf(10), BigDecimal.valueOf(100), "BASIC");
        when:
            def calculationOutput = taxService.performTaxCalculations(taxComputationParameters);
        then:
            calculationOutput == BigDecimal.valueOf(10)
    }

    def "Basic tax shouldn't be correctly calculated."() {
        given:
            def taxComputationParameters = new TaxComputationParameters(BigDecimal.valueOf(10), BigDecimal.valueOf(100), "BASIC");
        when:
            def calculationOutput = taxService.performTaxCalculations(taxComputationParameters);
        then:
            calculationOutput != BigDecimal.valueOf(10.01)
            calculationOutput != BigDecimal.valueOf(9.99)
    }

    def "Custom tax should be correctly calculated."() {
        given:
            def taxComputationParameters = new TaxComputationParameters(BigDecimal.valueOf(10), BigDecimal.valueOf(100), "CUSTOM");
        when:
            def calculationOutput = taxService.performTaxCalculations(taxComputationParameters);
        then:
            calculationOutput == BigDecimal.valueOf(1)
    }

}