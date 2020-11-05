package com.loylty.retail.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.loylty.retail.customer.engine.service.MultiGroupEntityManager;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	private MultiGroupEntityManager multiGroupEntityManager;
	
//	@Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:test");
//        dataSourceBuilder.username("SA");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//	}
	
	@Bean
	@DependsOn("multiGroupEntityManager")
	public DataSource dataSource() {
		RoutingDataSourceByGroup routingDataSourceByGroup = new RoutingDataSourceByGroup();
		routingDataSourceByGroup.setTargetDataSources(multiGroupEntityManager.getDataSourceTargets());
		return routingDataSourceByGroup;
	}
	
//	@Bean("transactionManager")
//	MongoTransactionManager mongodbTransactionManger(MongoDatabaseFactory dbFactory) {
//	    return new MongoTransactionManager(dbFactory);
//	}
}
