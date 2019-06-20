package com.howtobe.taskhandler.repository;

import com.howtobe.taskhandler.model.BudgetEntryStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class BudgetEntryStatusConverter implements AttributeConverter<BudgetEntryStatus, String> {
    @Override
    public String convertToDatabaseColumn(BudgetEntryStatus budgetEntryStatus) {
        if (budgetEntryStatus == null) {
            return null;
        }
        return budgetEntryStatus.getCode();
    }

    @Override
    public BudgetEntryStatus convertToEntityAttribute(String s) {
        if (s == null) return null;
        return Arrays.stream(BudgetEntryStatus.values())
                .filter(b -> b.getCode().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
