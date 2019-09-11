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
