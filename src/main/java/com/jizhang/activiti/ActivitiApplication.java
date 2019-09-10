package com.jizhang.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
@MapperScan("com.jizhang.activiti.mapper")
public class ActivitiApplication {

    
    @Autowired
    private ProcessEngine processEngine;
    
    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String index() {
        System.out.println("------------taskService:>>>>>>" + taskService);
        System.out.println("------------processEngine:>>>>>>" + processEngine);
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }
}
