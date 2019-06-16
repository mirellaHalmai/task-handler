package com.howtobe.taskhandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetEntry {

    Long id;
    String description;
    Currency currency;
    BigDecimal amount;
    BudgetEntryType type;
    BudgetEntryStatus status;
    LocalDate due;
}