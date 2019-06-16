package com.howtobe.taskhandler.controller;

import com.howtobe.taskhandler.model.BudgetEntry;
import com.howtobe.taskhandler.model.SimpleTask;
import com.howtobe.taskhandler.model.Task;
import com.howtobe.taskhandler.model.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TaskController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/tasks")
    public Task getTasks(){
        Task task = new SimpleTask();
        task.setDescription("Create project structure");
        task.setTaskType(TaskType.WORK);
        return task;
    }

    @GetMapping("/log")
    public BudgetEntry logSthg() {
        try {
            return restTemplate.exchange("http://localhost:9001/budget/1",
                    HttpMethod.GET
                    , null, new ParameterizedTypeReference<BudgetEntry>() {
                    }).getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage()
            );
        }
    }
}
