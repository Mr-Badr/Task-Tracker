package com.badr.task_app.services;

import com.badr.task_app.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
    Optional<TaskList> getTaskList(UUID id);
    TaskList updateTaskList(UUID taskListId, TaskList taskList); // TaskList is the new Data from the user
    void deleteTaskList(UUID taskListId);
}
