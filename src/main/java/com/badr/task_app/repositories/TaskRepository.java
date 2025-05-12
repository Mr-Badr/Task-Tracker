package com.badr.task_app.repositories;

import com.badr.task_app.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    // Get a list of tasks by the task list id that they're related to
    List<Task> findByTaskListId(UUID taskListId);

    // Get a single task where the task list ID and the task ID are the same
    Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id);

    void deleteByTaskListIdAndId(UUID taskListId, UUID id);
}
