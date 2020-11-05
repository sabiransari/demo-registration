package com.loylty.retail.customer.engine.service;

import java.beans.PropertyVetoException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;

import com.loylty.retail.customer.engine.model.DatabaseConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Service
public class MultiGroupEntityManager {
	
//	private static Map<String, GroupEntityManager> groupIdToEntityManager = new ConcurrentHashMap<>();
//	private static Map<String, JpaTransactionManager> groupIdToEntityManager = new ConcurrentHashMap<>();
	private Map<Object, Object> groupIdToDataSource = new ConcurrentHashMap<>();
	
//	public GroupEntityManager getEntityMangerByGroupId(String groupId) {
//		GroupEntityManager groupEntityManager = groupIdToEntityManager.get(groupId);
//		if (groupEntityManager == null) {
//			throw new RuntimeException("Group Entity Manager not found");
//		}
//		return groupEntityManager;
//	}
	
//	public JpaTransactionManager getEntityMangerByGroupId(String groupId) {
//		JpaTransactionManager groupEntityManager = groupIdToEntityManager.get(groupId);
//		if (groupEntityManager == null) {
//			throw new RuntimeException("Group Entity Manager not found");
//		}
//		return groupEntityManager;
//	}
	
	@PostConstruct
	public void loadDBConfigurations() {
		String groupId0 = "4028249771a14c670171a158d29c0000";
		DatabaseConfig dbConfig0 = new DatabaseConfig();
		dbConfig0.setDatabaseType(Database.MYSQL);
		dbConfig0.setConnectionUrl("jdbc:mysql://localhost:3306/loylty_retail?allowPublicKeyRetrieval=true&useSSL=false");
		dbConfig0.setDabaseName("loytly_retail");
		dbConfig0.setDatabaseUser("app");
		dbConfig0.setDatabasePassword("Loylty@123");
		dbConfig0.setIp("localhost");
		dbConfig0.setPort("3306");
		loadDBConfigurations0(groupId0, dbConfig0);
		
		String groupId1 = "abcdef";
		DatabaseConfig dbConfig1 = new DatabaseConfig();
		dbConfig1.setDatabaseType(Database.MYSQL);
		dbConfig1.setConnectionUrl("jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useSSL=false");
		dbConfig1.setDabaseName("test");
		dbConfig1.setDatabaseUser("app");
		dbConfig1.setDatabasePassword("Loylty@123");
		dbConfig1.setIp("localhost");
		dbConfig1.setPort("3306");
		loadDBConfigurations0(groupId1, dbConfig1);
		
	}
	
	private void loadDBConfigurations0(String groupId, DatabaseConfig dbConfig) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);
		vendorAdapter.setDatabase(dbConfig.getDatabaseType());
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.loylty");
		factory.setDataSource(dataSource(dbConfig, groupId));
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		//change this in future
		jpaProperties.put("hibernate.connection.release_mode", "on_close");
		jpaProperties.put("hibernate.show_sql", false);
		jpaProperties.put("hibernate.dialect.sorage_engine", "innodb");
		jpaProperties.put("hibernate.dialect_resolvers", "org.hibernate.engine.jdbc.dialect.internal.StandardDialectResolver");
		jpaProperties.put("hibernate.hbm2ddl.charset_name", "latin1");
		factory.setJpaProperties(jpaProperties);
		Map<String, Object> jpaPropertyMap = factory.getJpaPropertyMap();
		factory.setJpaPropertyMap(jpaPropertyMap);
		factory.afterPropertiesSet();
		
		JpaTransactionManager jpaTransactionManger = new JpaTransactionManager();
		jpaTransactionManger.setEntityManagerFactory(factory.getObject());
		GroupEntityManager entityManager = new GroupEntityManager(jpaTransactionManger);
		
//		groupIdToEntityManager.put("4028249771a14c670171a158d29c0000", entityManager);
//		groupIdToEntityManager.put(groupId, jpaTransactionManger);
	}
	
	private DataSource dataSource(DatabaseConfig databaseInformation, String groupId) {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		}
		catch (PropertyVetoException propertyVetoException) {
			propertyVetoException.printStackTrace();
		}
		dataSource.setUser(databaseInformation.getDatabaseUser());
		dataSource.setPassword(databaseInformation.getDatabasePassword());
		dataSource.setJdbcUrl(databaseInformation.getConnectionUrl() + "?autoReconnect=true&useSSL=false");
		dataSource.setInitialPoolSize(2);
		dataSource.setBreakAfterAcquireFailure(false);
		dataSource.setAcquireRetryAttempts(0);
		dataSource.setAcquireRetryDelay(5000);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(200);
		dataSource.setAcquireIncrement(1);
		dataSource.setMaxIdleTime(30000);
		dataSource.setMaxIdleTimeExcessConnections(100);
		dataSource.setPreferredTestQuery("SELECT 1 FROM DUAL");
		dataSource.setTestConnectionOnCheckin(false);
		dataSource.setTestConnectionOnCheckout(true);
		
		groupIdToDataSource.put(groupId, dataSource);
		
		return dataSource;
	}
	
	public class GroupEntityManager {
		private JpaTransactionManager jpaTransactionManager;

		public GroupEntityManager(JpaTransactionManager jpaTransactionManager) {
			this.jpaTransactionManager = jpaTransactionManager;
		}
		
		public EntityManager getEntityManager() {
			EntityManager entityManager = null;
			if (jpaTransactionManager != null) {
				EntityManagerFactory entityManagerFactory = jpaTransactionManager.getEntityManagerFactory();
				entityManager = entityManagerFactory.createEntityManager();
			}
			return entityManager;
		}
		
		public JpaTransactionManager getJpaTransactionManager() {
			return jpaTransactionManager;
		}
	}

//	public static EntityManager getEntityManagerByGroupId(@NotNull String groupId) {
//		GroupEntityManager groupEntityManager = groupIdToEntityManager.get(groupId);
//		if (groupEntityManager != null) {
//			return groupEntityManager.getEntityManager();
//		}
//		return null;
//	}
	
//	public static EntityManager getEntityManagerByGroupId(@NotNull String groupId) {
//		JpaTransactionManager groupEntityManager = groupIdToEntityManager.get(groupId);
//		if (groupEntityManager != null) {
//			return groupEntityManager.getEntityManagerFactory().createEntityManager();
//		}
//		return null;
//	}
	
	public Map<Object, Object> getDataSourceTargets() {
		return groupIdToDataSource;
	}
}
