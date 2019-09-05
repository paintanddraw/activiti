package com.jizhang.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.zl.mapper")
public class ActivitiApplication {

    private static final Logger logger = LoggerFactory.getLogger(ActivitiApplication.class);

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;

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
