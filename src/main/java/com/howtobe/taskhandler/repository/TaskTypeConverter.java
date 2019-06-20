package com.howtobe.taskhandler.repository;

import com.howtobe.taskhandler.model.TaskType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class TaskTypeConverter implements AttributeConverter<TaskType, String> {

    @Override
    public String convertToDatabaseColumn(TaskType taskType) {
        if (taskType == null) {
            return null;
        }
        return taskType.getCode();
    }

    @Override
    public TaskType convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Arrays.stream(TaskType.values())
                .filter(e -> e.getCode().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}