package com.jizhang.activiti.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MybatisConfig {
	
	@Resource(name = "bizDataSource")
	private DataSource bizDataSource;
	
	@Bean
	public SqlSessionFactory slqSessionFactory() throws Exception {
	    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	    sqlSessionFactoryBean.setDataSource(bizDataSource);
	    return sqlSessionFactoryBean.getObject();
	}
}
