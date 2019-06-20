package com.howtobe.taskhandler.repository;

import com.howtobe.taskhandler.model.Task;
import com.howtobe.taskhandler.model.TaskType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "/tasks", path = "/tasks")
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Query("select t from Task t where :taskType member of t.taskTypeList")
    List<Task> findByTaskType(@Param("taskType") TaskType taskType);

    List<Task> findByTaskTypeListContains(@Param("taskType") TaskType taskType);
}