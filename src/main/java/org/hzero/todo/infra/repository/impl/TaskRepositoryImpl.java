package org.hzero.todo.infra.repository.impl;

import io.choerodon.core.exception.CommonException;
import org.hzero.todo.api.dto.TaskExportDTO;
import org.hzero.todo.domain.entity.Task;
import org.hzero.todo.domain.repository.TaskRepository;
import org.hzero.todo.infra.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TaskRepositoryImpl implements TaskRepository {

    private TaskMapper taskMapper;

    @Autowired
    public TaskRepositoryImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Task create(Task task) {
        List<Task> taskList = taskMapper.select(task);
        if (!taskList.isEmpty()) {
            throw new CommonException("error.repo.create.task.exist");
        }
        if (taskMapper.insertSelective(task) != 1) {
            throw new CommonException("error.repo.create.task.failed");
        }
        return taskMapper.selectByPrimaryKey(task.getId());
    }

    @Override
    public Task queryById(Long id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TaskExportDTO> exportList(TaskExportDTO record) {
        return taskMapper.selectForExport();
    }

    @Override
    public void deleteById(Long id) {
        if (taskMapper.selectByPrimaryKey(id) == null) {
            throw new CommonException("error.task.not.exist");
        }
        if (taskMapper.deleteByPrimaryKey(id) != 1) {
            throw new CommonException("error.task.delete");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByTaskNumber(String taskNumber) {
        Task task = taskMapper.selectByTaskNumber(taskNumber);
        if (task == null) {
            throw new CommonException("error.task.not.exist");
        }
        if (taskMapper.deleteByPrimaryKey(task.getId()) != 1) {
            throw new CommonException("error.task.delete");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Task update(Task task) {
        if (taskMapper.updateByPrimaryKeySelective(task) != 1) {
            throw new CommonException("error.task.update");
        }
        return taskMapper.selectByPrimaryKey(task.getId());
    }
}
