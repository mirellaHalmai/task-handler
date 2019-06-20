package com.howtobe.taskhandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private List<TaskType> taskTypeList = new ArrayList<>();
    private String location;
    private BudgetEntry budgetEntry;
    private LocalDateTime from;
    private LocalDateTime to;
    private ChronoUnit recurrence;
    private ChronoUnit alert;
    private boolean done;

    public void addTaskType(TaskType taskType) {
        taskTypeList.add(taskType);
    }
}
