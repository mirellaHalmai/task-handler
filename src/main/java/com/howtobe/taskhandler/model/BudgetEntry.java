package com.howtobe.taskhandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Currency;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BudgetEntry {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Currency currency;
    private BigDecimal amount;
    private BudgetEntryType type;
    private BudgetEntryStatus status;
    private LocalDate due;
    private boolean periodic;
    private ChronoUnit period;
    @OneToOne(mappedBy = "budgetEntry")
    private Task task;
}