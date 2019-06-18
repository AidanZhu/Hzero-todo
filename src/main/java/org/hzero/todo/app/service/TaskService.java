package org.hzero.todo.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.export.vo.ExportParam;
import org.hzero.todo.api.dto.TaskExportDTO;
import org.hzero.todo.domain.entity.Task;

import java.util.List;

public interface TaskService {

    Task create(Task task);

    void deleteById(Long id);

    void deleteByTaskNumber(String taskNumber);

    Task selectByTaskNumber(String taskNumber);

    Task update(Task task);

    Task queryById(Long id);

    Page<TaskExportDTO> export(TaskExportDTO record, ExportParam exportParam, PageRequest pageRequest);

    List<TaskExportDTO> exportList(TaskExportDTO record);
}
