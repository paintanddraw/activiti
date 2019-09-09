package com.jizhang.activiti.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSourceRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.get();
	}

}
