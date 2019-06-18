package org.hzero.todo.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import org.hzero.mybatis.annotation.DataSecurity;
import org.hzero.mybatis.annotation.Unique;
import org.hzero.mybatis.common.query.Where;
import org.hzero.mybatis.helper.DataSecurityHelper;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ModifyAudit //在类上使用，启用审计字段支持，实体类加上该注解后，插入和更新会启动对creationDate、createdBy、lastUpdateDate、lastUpdatedBy自维护字段支持
@VersionAudit //在类上使用，启用objectVersionNumber自维护支持，插入一条数据objectVersionNumber默认为1，每次update后objectVersionNumber自增1
@Table(name = "todo_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends AuditDomain { //AuditDomain包含5个自维护字段，使用@ModifyAudit和@VersionAudit的实体类要继承该类
    @Id
    @GeneratedValue //对于自增张、序列（SEQUENCE）类型的主键，需要添加该注解
    private Long id;
    private String employeeName;

    @Where
    @Unique
    private String employeeNumber;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}