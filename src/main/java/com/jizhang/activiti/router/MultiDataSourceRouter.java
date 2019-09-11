package com.jizhang.activiti.router;

import com.jizhang.activiti.utils.DataSourceHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 18:51
 * @Desc: 多数据源路由选择
 */
public class MultiDataSourceRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.get();
	}

}
