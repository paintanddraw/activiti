package com.jizhang.activiti.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.jizhang.activiti.constants.DataSourceConstants;
import com.jizhang.activiti.router.MultiDataSourceRouter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 18:51
 * @Desc: druid 多数据源配置
 */
@Order(1)
@Configuration
@MapperScan("com.jizhang.activiti.mapper")
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
	
	
	@Bean("dataSource")
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
     * 配置事务管理
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
