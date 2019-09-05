package com.jizhang.activiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jizhang.activiti.entity.LeaveInfo;

@Mapper
public interface LeaveMapper {

	int getCount();
	
	void insert(LeaveInfo entity);
	
	void delete(String id);
	
	LeaveInfo getById(String id);
	
	List<LeaveInfo> getList();
	
	void update(LeaveInfo entity);
}
