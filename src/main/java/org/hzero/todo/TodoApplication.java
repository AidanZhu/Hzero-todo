package org.hzero.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;

@SpringBootApplication
// 是否允许注册到注册中心，暂时注释掉
// @EnableEurekaClient
@RestController
// 是否开启猪齿鱼资源服务器，暂时注释掉
// @EnableChoerodonResourceServer
public class TodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @GetMapping
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @ApiOperation(value = "demo")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello world", HttpStatus.OK);
    }
}