package org.hzero.todo.domain.repository;

import org.hzero.todo.api.dto.TaskExportDTO;
import org.hzero.todo.domain.entity.Task;

import java.util.List;

public interface TaskRepository {
    Task create(Task task);

    void deleteById(Long id);

    void deleteByTaskNumber(String taskNumber);

    Task update(Task task);

    Task queryById(Long id);

    List<TaskExportDTO> exportList(TaskExportDTO record);
}