package com.howtobe.taskhandler.repository;

import com.howtobe.taskhandler.model.BudgetEntryType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class BudgetEntryTypeConverter implements AttributeConverter<BudgetEntryType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BudgetEntryType budgetEntryType) {
        if (budgetEntryType == null) {
            return null;
        }
        return budgetEntryType.getCode();
    }

    @Override
    public BudgetEntryType convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return null;
        }
        return Arrays.stream(BudgetEntryType.values())
                .filter(b -> b.getCode().equals(integer))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}