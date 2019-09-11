package com.jizhang.activiti.service.impl;

import com.jizhang.activiti.annotation.DataSource;
import com.jizhang.activiti.constants.DataSourceConstants;
import com.jizhang.activiti.entity.UserInfo;
import com.jizhang.activiti.mapper.UserInfoMapper;
import com.jizhang.activiti.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * @DataSource(DataSourceConstants.ACTIVITI_DATASOURCE)  用来测试数据源切换
	 */
	@Override
	@DataSource(DataSourceConstants.ACTIVITI_DATASOURCE)
	public UserInfo queryOne(Integer id) {
		return userInfoMapper.selectById(id);
	}

}
