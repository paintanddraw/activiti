package com.jizhang.activiti.bpmnmodel;

import java.nio.charset.Charset;
import java.util.List;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.RepositoryService;
import org.activiti.validation.ProcessValidator;
import org.activiti.validation.ProcessValidatorFactory;
import org.activiti.validation.ValidationError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jizhang.activiti.ActivitiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ActivitiApplication.class})
public class ModelTest {
	
	@Autowired
	private RepositoryService repositoryService;

	@Test
	public void convertToXML(){
		BpmnXMLConverter converter = new BpmnXMLConverter();
		BpmnModel bpmnModel = repositoryService.getBpmnModel("commonCallActivityProcess:1:40007");
		byte[] bs = converter.convertToXML(bpmnModel);
		System.out.println("XML: " + new String(bs, Charset.forName("UTF-8")));
		
		//验证bpmnmodel是否是正确的bpmn xml文件
		ProcessValidatorFactory processValidatorFactory = new ProcessValidatorFactory();
		ProcessValidator processValidator = processValidatorFactory.createDefaultProcessValidator();
		List<ValidationError> errorList = processValidator.validate(bpmnModel);
		//errorList.size()为0 说明没有错误，大于0 说明有问题不可以使用,再部署之前可以进行验证
		System.out.println("size: " + errorList.size());
	}
	
}
