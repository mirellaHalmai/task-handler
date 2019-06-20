package com.howtobe.taskhandler.model;

import lombok.Getter;

@Getter
public enum TaskType {

    BUDGET("BUD", "Budget"),
    WORK("WRK", "Work"),
    FUN("FUN", "Fun"),
    ADMINISTRATION("ADM", "Administration"),
    OTHER("OTH", "Other");

    private String code;
    private String name;

    TaskType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
