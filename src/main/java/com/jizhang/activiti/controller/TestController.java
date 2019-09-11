package com.jizhang.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jizhang.activiti.entity.UserInfo;
import com.jizhang.activiti.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/user/{id}")
	public UserInfo test01(@PathVariable("id") Integer id){
		return testService.queryOne(id);
	}
}
