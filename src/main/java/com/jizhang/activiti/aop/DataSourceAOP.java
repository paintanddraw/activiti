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
 * 使用AOP拦截特定的注解去动态的切换数据源
 * @author Administrator
 *
 */

@Aspect
@Component
@Slf4j
@Order(-100)
public class DataSourceAOP {

	@Pointcut("@within(com.jizhang.activiti.annotation.DataSource)" +
            "|| @annotation(com.jizhang.activiti.annotation.DataSource)")
	public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint)
    {
    	Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
    	System.out.println("=========================================={}" + method.getName());
        DataSource annotationClass = method.getAnnotation(DataSource.class);
        if(annotationClass == null){
            annotationClass = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
            if(annotationClass == null) return;
        }
        //获取注解上的数据源的值的信息
        String dataSourceKey = annotationClass.value();
        if(dataSourceKey !=null){
            //给当前的执行SQL的操作设置特殊的数据源的信息
            DataSourceHolder.set(dataSourceKey);
        }
        log.info("AOP动态切换数据源，className"+joinPoint.getTarget().getClass().getName()+"methodName"+method.getName()+";dataSourceKey:"+dataSourceKey==""?"默认数据源":dataSourceKey);
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        DataSourceHolder.clear();
    }
}
