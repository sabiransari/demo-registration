package com.loylty.retail.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSourceByGroup extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		return GroupIdContextHolder.get();
	}

}
