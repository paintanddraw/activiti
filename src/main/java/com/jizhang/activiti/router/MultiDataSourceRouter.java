package com.jizhang.activiti.router;

import com.jizhang.activiti.utils.DataSourceHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSourceRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.get();
	}

}
