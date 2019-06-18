package org.hzero.todo.infra.mapper;

import feign.Param;
import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.todo.api.dto.TaskExportDTO;
import org.hzero.todo.domain.entity.Task;

import java.util.List;

public interface TaskMapper extends BaseMapper<Task> {
    Task selectByTaskNumber(@Param("taskNumber") String taskNumber);

    List<TaskExportDTO> selectForExport();
}