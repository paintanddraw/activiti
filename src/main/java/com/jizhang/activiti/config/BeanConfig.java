package com.jizhang.activiti.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.jizhang.activiti.utils.MultiDataSourceRouter;

@Configuration
public class BeanConfig {
	
	@Autowired
	private DataSource defaultDataSource;
	
	@Resource(name = "activitiDataSource")
	private DataSource activitiDataSource;
	/**
	 * 分页插件注册
	 * @return
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}
	
	@Bean
	public MultiDataSourceRouter multiDataSourceRouter(){
		MultiDataSourceRouter dataSourceRouter = new MultiDataSourceRouter();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put("DEFAULT", defaultDataSource);
		targetDataSources.put("ACTIVITI", activitiDataSource);
		dataSourceRouter.setTargetDataSources(targetDataSources);
		dataSourceRouter.setDefaultTargetDataSource(defaultDataSource);
		return dataSourceRouter;
	}
}
