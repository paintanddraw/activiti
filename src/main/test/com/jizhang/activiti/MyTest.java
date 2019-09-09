package com.jizhang.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jizhang.activiti.entity.LeaveInfo;
import com.jizhang.activiti.entity.UserInfo;
import com.jizhang.activiti.mapper.LeaveMapper;
import com.jizhang.activiti.mapper.UserInfoMapper;
import com.jizhang.activiti.utils.DataSourceHolder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

	@Autowired
	private LeaveMapper leaveMapper;
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Test
	public void userTest(){
		DataSourceHolder.set(Con);
		UserInfo userInfo = userInfoMapper.selectById(123);
		System.out.println("userinfo: " + userInfo);
	}
	
	@Test
	public void processEngineTest(){
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		long count = processDefinitionQuery.count();
		System.out.println("count: " + count);
	}
	
	@Test
	public void test(){
		LeaveInfo leaveInfo = leaveMapper.selectById(123);
		System.out.println(leaveInfo.toString());
	}
	
}
