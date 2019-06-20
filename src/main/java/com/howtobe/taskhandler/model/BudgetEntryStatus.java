package com.howtobe.taskhandler.model;

import lombok.Getter;

@Getter
public enum BudgetEntryStatus {
    TODO ("T"),
    DONE_FOR_PERIOD ("DP"),
    DONE ("D");

    private String code;

    BudgetEntryStatus(String code) {
        this.code = code;
    }
}