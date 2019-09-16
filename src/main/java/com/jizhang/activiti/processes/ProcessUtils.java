package com.jizhang.activiti.processes;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 流程相关的通用方法
 * 
 * @author Administrator
 *
 */
public class ProcessUtils {

	@Autowired
	private ProcessEngine processEngine;

	public void findMyPersonTask() {

		String assignee = "a";
		List<Task> taskList = processEngine.getTaskService()// 获取任务service
				.createTaskQuery()// 创建查询对象
				// .taskAssignee(assignee)//指定查询人
				.taskCandidateUser(assignee)// 参与者，组任务查询
				.list();

		if (taskList.size() > 0) {
			for (Task task : taskList) {
				System.out.println("代办任务ID:" + task.getId());
				System.out.println("代办任务name:" + task.getName());
				System.out.println("代办任务创建时间:" + task.getCreateTime());
				System.out.println("代办任务办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
			}
		}
	}
}
