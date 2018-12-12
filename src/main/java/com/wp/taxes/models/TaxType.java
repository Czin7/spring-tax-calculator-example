package com.wp.taxes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum TaxType {
    BASIC("BASIC"), CUSTOM("CUSTOM");
    @Getter private String name;
}
