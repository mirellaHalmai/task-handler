package com.howtobe.taskhandler.model;

import lombok.Getter;

@Getter
public enum BudgetEntryType {
    INCOME (1),
    EXPENDITURE (0);

    private Integer code;

    BudgetEntryType(int code) {
        this.code = code;
    }
}