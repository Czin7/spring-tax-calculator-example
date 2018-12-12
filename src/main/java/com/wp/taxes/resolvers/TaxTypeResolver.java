package com.wp.taxes.resolvers;

import com.wp.taxes.models.TaxType;
import org.springframework.stereotype.Component;

@Component
public class TaxTypeResolver {

    public TaxType resolve(String taxTypeFromDb){
        if(TaxType.BASIC.getName().equals(taxTypeFromDb)) return TaxType.BASIC;
        return TaxType.CUSTOM;
    }
}
