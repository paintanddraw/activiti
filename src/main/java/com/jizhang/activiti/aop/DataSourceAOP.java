package com.jizhang.activiti.aop;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.jizhang.activiti.annotation.DataSource;
import com.jizhang.activiti.utils.DataSourceHolder;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 18:51
 * @Desc: 通过AOP, 在拥有{@link DataSource}注解类和方法上进行数据源的设置
 */
@Aspect
@Component
@Slf4j
@Order(-100)
public class DataSourceAOP {

	/**
	 * @within 表示注解在类型的注解
	 * @annotation 表示注解在方法上的注解
	 */
	@Pointcut("@within(com.jizhang.activiti.annotation.DataSource)" +
            "|| @annotation(com.jizhang.activiti.annotation.DataSource)")
	public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint)
    {
    	Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if(annotation == null){
        	annotation = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
            if(annotation == null) {
                return;
            }
        }
        //获取自定义注解@DataSource 的 value值
        String dataSourceKey = annotation.value();
        if(dataSourceKey !=null){
            //给当前的执行SQL的操作设置特殊的数据源的信息
            DataSourceHolder.set(dataSourceKey);
        }
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        DataSourceHolder.clear();
    }
}
