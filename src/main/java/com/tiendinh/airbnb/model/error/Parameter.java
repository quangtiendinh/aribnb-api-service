package com.tiendinh.airbnb.model.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parameter {
    private String fieldName;
    private Object value;

    public static Parameter of(String fieldName, Object value) {
        return new Parameter(fieldName, value);
    }

    public Parameter(final String fieldName, final Object value) {
        this.fieldName = fieldName;
        this.value = value;
    }
}
