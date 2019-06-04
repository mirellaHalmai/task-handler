package com.howtobe.taskhandler.controller;

import com.howtobe.taskhandler.model.SimpleTask;
import com.howtobe.taskhandler.model.Task;
import com.howtobe.taskhandler.model.TaskType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TaskController {

    @RequestMapping("/tasks")
    public Task getTasks(){
        Task task = new SimpleTask();
        task.setDescription("Create project structure");
        task.setTaskType(TaskType.WORK);
        return task;
    }
}
