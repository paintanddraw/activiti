package com.jizhang.activiti.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@ToString
@TableName(value = "work_order_product")
public class WorkOrderInfo implements Serializable{
	
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	
	@TableField(value = "parent_id")
	private String parentId;
	
	@TableField(value = "product_name")
	private String productName;
	
	@TableField(value = "prode")
	private Date createdTime;
	
}
