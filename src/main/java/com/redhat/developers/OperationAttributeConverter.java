package com.redhat.developers;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OperationAttributeConverter implements AttributeConverter<Operation, String> {
    @Override
    public String convertToDatabaseColumn(Operation attribute) {
        return attribute.toDatabaseValue();
    }

    @Override
    public Operation convertToEntityAttribute(String dbData) {
        return Operation.fromString(dbData).orElse(Operation.ADD);
    }
}
