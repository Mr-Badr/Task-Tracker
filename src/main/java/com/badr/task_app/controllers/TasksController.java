package com.badr.task_app.controllers;

import com.badr.task_app.domain.dto.TaskDto;
import com.badr.task_app.mappers.TaskMapper;
import com.badr.task_app.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{task-list-id}/tasks")
public class TasksController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TasksController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task-list-id") UUID taskListId){
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskDto createTask(@PathVariable("task-list-id") UUID taskListId, @RequestBody TaskDto taskDto){
        return taskMapper.toDto(taskService.createTask(taskListId, taskMapper.fromDto(taskDto)));
    }
}
