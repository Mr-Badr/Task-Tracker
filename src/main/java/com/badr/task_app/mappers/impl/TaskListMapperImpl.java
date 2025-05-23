package com.badr.task_app.mappers.impl;

import com.badr.task_app.domain.dto.TaskListDto;
import com.badr.task_app.domain.entities.Task;
import com.badr.task_app.domain.entities.TaskList;
import com.badr.task_app.domain.entities.TaskStatus;
import com.badr.task_app.mappers.TaskListMapper;
import com.badr.task_app.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream().map(taskMapper::toDto).toList()
                        ).orElse(null)
        );
    }

    private Double calculateProgress(List<Task> tasks) {
        if (tasks == null) return 0.0;
        return tasks.stream()
                .filter(task -> task.getStatus() == TaskStatus.CLOSED)
                .count() / (double) tasks.size();
    }
}
