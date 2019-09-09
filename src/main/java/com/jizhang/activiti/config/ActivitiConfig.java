package com.jizhang.activiti.config;

import java.io.IOException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;

@Order(2)
@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration{

	@Resource(name = "activitiDataSource")
	private DataSource activitiDataSource;
	
	
	@Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            PlatformTransactionManager transactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {

        return baseSpringProcessEngineConfiguration(
                activitiDataSource,
                transactionManager,
                springAsyncExecutor);
    }
}