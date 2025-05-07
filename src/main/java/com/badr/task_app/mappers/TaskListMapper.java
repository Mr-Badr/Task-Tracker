package com.badr.task_app.mappers;

import com.badr.task_app.domain.dto.TaskListDto;
import com.badr.task_app.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
