package com.badr.task_app.services.impl;

import com.badr.task_app.domain.entities.TaskList;
import com.badr.task_app.repositories.TaskListRepository;
import com.badr.task_app.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if (null != taskList.getId()){
            throw new IllegalArgumentException("Task list already has an ID!");
        }
        if (null == taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task list title cannot be empty!");
        }

        LocalDateTime now = LocalDateTime.now();
        taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));

        return null;
    }
}
