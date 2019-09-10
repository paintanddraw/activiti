package com.jizhang.activiti.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.jizhang.activiti.constants.DataSourceConstants;
import com.jizhang.activiti.router.MultiDataSourceRouter;

@Order(1)
@Configuration
public class DruidConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.druid")
	public DataSource defaultDataSource(){
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	
	@Bean("activitiDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.activiti")
	public DataSource activitiDataSource(){
		  return DataSourceBuilder.create().build();
	}
	
	
	@Bean
	public MultiDataSourceRouter dataSource(){
		MultiDataSourceRouter dataSourceRouter = new MultiDataSourceRouter();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(DataSourceConstants.DEFAULT_DATASOURCE, defaultDataSource());
		targetDataSources.put(DataSourceConstants.ACTIVITI_DATASOURCE, activitiDataSource());
		dataSourceRouter.setTargetDataSources(targetDataSources);
		dataSourceRouter.setDefaultTargetDataSource(defaultDataSource());
		return dataSourceRouter;
	}
	
	/**
     * 配置事务管理 Configuration transaction management
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

	@Bean
	@ConfigurationProperties(prefix = "mybatis-plus")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		return bean.getObject();
	}
}
