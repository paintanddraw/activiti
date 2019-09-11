package com.jizhang.activiti.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 18:51
 * @Desc: 自定义的bean
 */
@Configuration
public class BeanConfig {
	
	/**
	 * 分页插件注册
	 * @return
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}

}
