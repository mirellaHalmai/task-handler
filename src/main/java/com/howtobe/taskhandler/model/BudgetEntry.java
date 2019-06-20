package com.howtobe.taskhandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BudgetEntry {

    @Id
    @GeneratedValue
    Long id;
    String description;
    Currency currency;
    BigDecimal amount;
    BudgetEntryType type;
    BudgetEntryStatus status;
    LocalDate due;
}