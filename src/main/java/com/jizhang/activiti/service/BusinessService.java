package com.jizhang.activiti.service;

import java.util.Arrays;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("businessService")
public class BusinessService {

	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RuntimeService runtimeService;

	/**
	 * 启动流程
	 * 
	 */
	public void startProcess(String bizKey) {
		//第一个参数是指定启动流程的id,即要启动哪个流程 ;第二个参数是指业务id
		System.out.println("启动前-----");
		runtimeService.startProcessInstanceByKey("businessServiceProcess", bizKey);
		System.out.println("启动之后------");
	}
	
	
	/**
	 * 根据多个任务的id,进行callActiviti的多实例
	 */
	public List<String> findWorkOrderList(){
		return Arrays.asList("eeb6f608-786c-46d0-995f-3d3e371842d5", "e18edc97-c2f6-45d8-b7ef-e47c77326c68");
	}
}
