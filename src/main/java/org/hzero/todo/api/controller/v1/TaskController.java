package org.hzero.todo.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.hzero.todo.api.dto.TaskExportDTO;
import org.hzero.todo.app.service.TaskService;
import org.hzero.todo.domain.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "创建task")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return Results.success(taskService.create(task));
    }

    @DeleteMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据id删除task")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @DeleteMapping("/taskNumber/{taskNumber}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据TaskNumber删除task")
    public void deleteByTaskNumber(@PathVariable String taskNumber) {
        taskService.deleteByTaskNumber(taskNumber);
    }

    @PutMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "更新task")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return Results.success(taskService.update(task));
    }

    @GetMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "查询task")
    public ResponseEntity<Task> query(@PathVariable Long id) {
        return Results.success(taskService.queryById(id));
    }

    @GetMapping("/export")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "导出列表")
    @ExcelExport(TaskExportDTO.class)
    public ResponseEntity<Page<TaskExportDTO>> export(TaskExportDTO record, ExportParam exportParam, HttpServletResponse response, PageRequest pageRequest) {
        return Results.success(taskService.export(record, exportParam, pageRequest));
    }

    @GetMapping("/exportlist")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "导出列表")
    public ResponseEntity<List<TaskExportDTO>> exportList(TaskExportDTO record) {
        return Results.success(taskService.exportList(record));
    }

    @GetMapping("/taskNumber/{taskNumber}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "taskNumber查询task")
    public ResponseEntity<Task> queryByNumber(@PathVariable String taskNumber) {
        return Results.success(taskService.selectByTaskNumber(taskNumber));
    }

}