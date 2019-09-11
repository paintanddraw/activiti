package com.jizhang.activiti.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "leave_info")
public class LeaveInfo {
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	
	@TableField(value = "status")
	private String status;
	
	@TableField(value = "leave_msg")
	private String leaveMsg;
	
	private String taskId;
}
