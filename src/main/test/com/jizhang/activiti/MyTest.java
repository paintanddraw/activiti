package com.jizhang.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

	@Autowired
	private ProcessEngine processEngine;
	
	private RepositoryService repositoryService;

	private RuntimeService runtimeService;
	
	private TaskService taskService;
	
	private ProcessInstance pi =  null;
	@Test
	public void repositoryService(){
		repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		long count = processDefinitionQuery.count();
		System.out.println("count: " + count);
	}

	@Test
	public void runtimeService(){
		pi = runtimeService.startProcessInstanceByKey("leaveProcess");
		System.out.println("Leave process started with process instance id ["
				+ pi.getProcessInstanceId() + "] key [" + pi.getProcessDefinitionKey() + "]");
	}
	
	@Test
	public void taskService(){
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		
		System.out.println("当前任务的昵称： " + task.getName());
	}

}
