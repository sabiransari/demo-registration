package com.loylty.retail.customer.engine.model;

import org.springframework.orm.jpa.vendor.Database;

public class DatabaseConfig {
	private Database databaseType;
    private String ip;
    private String port;
    private String dabaseName;
    private String connectionUrl;
    private String databaseUser;
    private String databasePassword;
    
	public Database getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(Database databaseType) {
		this.databaseType = databaseType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDabaseName() {
		return dabaseName;
	}
	public void setDabaseName(String dabaseName) {
		this.dabaseName = dabaseName;
	}
	public String getConnectionUrl() {
		return connectionUrl;
	}
	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
	public String getDatabaseUser() {
		return databaseUser;
	}
	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}
	public String getDatabasePassword() {
		return databasePassword;
	}
	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
}
