package com.jizhang.activiti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jizhang.activiti.entity.LeaveInfo;

public interface LeaveMapper extends BaseMapper<LeaveInfo>{

	/**
	 * 更新请假信息
	 * @param leaveInfo
	 */
	void update(LeaveInfo leaveInfo);

	/**
	 * 添加一条请假信息
	 * @param leaveInfo
	 */
	@Override
	int insert(LeaveInfo leaveInfo);

	/**
	 * 根据请假id, 去查请假信息
	 * @param id
	 * @return
	 */
	//@Select("select * from leave_info where id = #{id}")
	LeaveInfo getById(String id);

}
