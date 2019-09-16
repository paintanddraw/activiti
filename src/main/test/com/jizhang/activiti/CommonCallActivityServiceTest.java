package com.jizhang.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jizhang.activiti.service.CommonCallActivityService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonCallActivityServiceTest {
	
	@Autowired
	private CommonCallActivityService commonCallActivityService;
	
	@Autowired
	private TaskService taskService;
	
	private String uuid = UUID.randomUUID().toString();
	
	@Test
	public void test(){
		System.out.println("uuid: " +uuid);
		commonCallActivityService.startProcess(uuid);
	}

	@Test
	public void testProcessInstance(){
		//List<Task> tasks = commonCallActivityService.findTaskByUserId(uuid);
		Task task = taskService.createTaskQuery().processInstanceBusinessKey("de6a3996-90de-4596-98b9-3f3a387052d7")
				.taskCandidateUser("Assigner1").singleResult();
		System.out.println("任务ID:"+task.getId());
		System.out.println("任务名称:"+task.getName());
		System.out.println("任务的创建时间:"+task.getCreateTime());
		System.out.println("任务的办理人:"+task.getAssignee());
		System.out.println("流程实例ID："+task.getProcessInstanceId());
		System.out.println("执行对象ID:"+task.getExecutionId());
		System.out.println("流程定义ID:"+task.getProcessDefinitionId());
		System.out.println("########################################################");
		
		//向组任务中添加成员
		taskService.addCandidateUser(task.getId(), "Assigner3");
		//向组任务中删除成员
		taskService.deleteCandidateUser(task.getId(), "Assigner3");
		
		//查询正在执行的任务办理人表
		List<IdentityLink> list = taskService.getIdentityLinksForTask(task.getId());
		if(list!=null && list.size()>0){
			for(IdentityLink identityLink:list){
				System.out.println(identityLink.getTaskId()+"   "+identityLink.getType()+"   "+identityLink.getProcessInstanceId()+"   "+identityLink.getUserId());
			}
		}
		
		//将组任务分给个人任务，指定任务的办理人字段
		taskService.claim(task.getId(), "Assigner1");
		
		//将个人任务回退到组任务
		//taskService.setAssignee(task.getId(), null);
		
		
		//完成任务并制定下一个任务的办理人
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("executor", "小王");
		taskService.complete(task.getId(), variables);
	}
	
	@Test
	public void testTask(){
		Task task = taskService.createTaskQuery().processInstanceBusinessKey("de6a3996-90de-4596-98b9-3f3a387052d7")
				.taskAssignee("小王").singleResult();
		
		System.out.println("任务ID:"+task.getId());
		System.out.println("任务名称:"+task.getName());
		System.out.println("任务的创建时间:"+task.getCreateTime());
		System.out.println("任务的办理人:"+task.getAssignee());
		System.out.println("流程实例ID："+task.getProcessInstanceId());
		System.out.println("执行对象ID:"+task.getExecutionId());
		System.out.println("流程定义ID:"+task.getProcessDefinitionId());
		System.out.println("########################################################");
		
		//完成任务
		taskService.complete(task.getId());
	}
}
