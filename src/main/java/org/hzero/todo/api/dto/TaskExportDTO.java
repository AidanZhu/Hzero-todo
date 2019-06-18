package org.hzero.todo.api.dto;

import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;

@ExcelSheet(zh ="任务清单",en="Task List")
public class TaskExportDTO {
    @ExcelColumn(zh = "状态", en = "state")
    private String state;
    @ExcelColumn(zh = "任务编号", en = "Task Number")
    private String taskNumber;
    @ExcelColumn(zh = "任务描述", en = "Task Description")
    private String taskDescription;
    @ExcelColumn(zh = "员工姓名", en = "Employee Name")
    private String employeeName;

    //setter/getter...
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
