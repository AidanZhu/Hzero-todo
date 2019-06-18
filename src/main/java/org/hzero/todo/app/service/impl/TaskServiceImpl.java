package org.hzero.todo.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.Select;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.export.vo.ExportParam;
import org.hzero.todo.api.dto.TaskExportDTO;
import org.hzero.todo.app.service.TaskService;
import org.hzero.todo.domain.entity.Task;
import org.hzero.todo.domain.repository.TaskRepository;
import org.hzero.todo.infra.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.create(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void deleteByTaskNumber(String taskNumber) {
        taskRepository.deleteByTaskNumber(taskNumber);
    }

    @Override
    public Task selectByTaskNumber(String taskNumber) {
        return taskMapper.selectByTaskNumber(taskNumber);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public Task queryById(Long id) {
        return taskRepository.queryById(id);
    }

    @Override
    public Page<TaskExportDTO> export(TaskExportDTO record, ExportParam exportParam, PageRequest pageRequest) {
        //return PageHelper.doPageAndSort(pageRequest, () -> taskMapper.selectForExport());
        Select select = () -> taskMapper.selectForExport();
        return PageHelper.doPageAndSort(pageRequest,select);
    }

    @Override
    public List<TaskExportDTO> exportList(TaskExportDTO record) {
        return taskRepository.exportList(record);
    }
}