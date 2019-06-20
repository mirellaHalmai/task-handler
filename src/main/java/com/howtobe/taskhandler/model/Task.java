package com.howtobe.taskhandler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ElementCollection
    private List<TaskType> taskTypeList;
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    private BudgetEntry budgetEntry;
    private LocalDateTime taskStart;
    private LocalDateTime taskEnd;
    private ChronoUnit recurrence;
    private ChronoUnit alert;
    private boolean done;

    public void addTaskType(TaskType taskType) {
        if (taskTypeList == null) {
            taskTypeList = new ArrayList<>();
        }
        taskTypeList.add(taskType);
    }
}
