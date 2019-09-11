package com.jizhang.activiti.utils;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 18:51
 * @Desc: 多数据源上下文工具
 */
public class DataSourceHolder {
	
	private static ThreadLocal<String> dataSourceLocal = new ThreadLocal<String>();
	
	/**
	 * 设置数据源
	 * @param dataSource
	 */
	public static void set(String dataSource){
		dataSourceLocal.set(dataSource);
	}
	
	/**
	 * 获取数据源
	 * @return
	 */
	public static String get(){
		return dataSourceLocal.get();
	}
	
	/**
	 * 请出数据源
	 */
	public static void clear(){
		dataSourceLocal.remove();
	}
}
