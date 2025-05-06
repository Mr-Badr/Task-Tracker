package com.badr.task_app.mappers;

import com.badr.task_app.domain.dto.TaskDto;
import com.badr.task_app.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);

}
