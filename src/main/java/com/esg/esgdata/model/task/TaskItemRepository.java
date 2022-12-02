package com.esg.esgdata.model.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskItemRepository extends CrudRepository<TaskItem, TaskId> {
}
