package com.jizhang.activiti.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
@Order(1)
@Configuration
public class DruidConfig {

	/*@Bean("bizDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.biz")
	public DataSource bizDataSource(){
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}*/
	
	@Bean("activitiDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.activiti")
	public DataSource activitiDataSource(){
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	/*
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean( new StatViewServlet(), "/druid/*" );
        Map<String, String> initParams = new HashMap<>();

        initParams.put( "loginUsername", "admin" );
        initParams.put( "loginPassword", "admin" );
        initParams.put( "allow", "" );//默认允许所有
        initParams.put( "deny", "" );
        servletRegistrationBean.setInitParameters( initParams );
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statViewFilter()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(  );
        filterRegistrationBean.setFilter( new WebStatFilter());
        Map<String,String> initParams = new HashMap<>(  );
        initParams.put( "exclusions", "*.js,*.css,*.jpg,*.gif,/druid/*" );
        filterRegistrationBean.setInitParameters( initParams );
        filterRegistrationBean.setUrlPatterns( Arrays.asList("/*") );
        return filterRegistrationBean;
    }*/

}
