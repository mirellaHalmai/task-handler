package com.howtobe.taskhandler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Task {

    protected String description;
    protected TaskType taskType;

}
