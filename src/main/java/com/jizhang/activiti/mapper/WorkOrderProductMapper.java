package com.jizhang.activiti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jizhang.activiti.entity.WorkOrderProduct;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aaron
 * @since 2019-09-16
 */
public interface WorkOrderProductMapper extends BaseMapper<WorkOrderProduct> {
	
	/**
	 * 更新工单信息
	 * @param workOrderProduct
	 */
	void update(WorkOrderProduct workOrderProduct);
	
}
