package com.jizhang.activiti;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jizhang.activiti.service.BusinessService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServiceProcessTest {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	private String uuid = UUID.randomUUID().toString();

	@Test
	public void test() {
		businessService.startProcess(uuid);
	}

	@Test
	public void testProcessInstance() {

//		ProcessInstance pi = runtimeService
//				.createProcessInstanceQuery()
//				.processInstanceBusinessKey(
//						"c9dd6602-ac3b-497b-a761-f0631b731b08").singleResult();

		List<Task> list = taskService.createTaskQuery().processInstanceBusinessKey("eeb6f608-786c-46d0-995f-3d3e371842d5")
				.taskCandidateUser("Assigner1").list();
		
		if (null != list && list.size() > 0) {
			System.out.println("组任务下面的任务数：" + list.size());
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间:" + task.getCreateTime());
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out
						.println("########################################################");
			}
		}
	}

	@Test
	public void testTask() {

	}
}
