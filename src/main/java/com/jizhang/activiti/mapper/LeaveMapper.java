package com.jizhang.activiti.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jizhang.activiti.entity.LeaveInfo;

@Mapper
public interface LeaveMapper extends BaseMapper<LeaveInfo>{
	void update(LeaveInfo leaveInfo);
}
