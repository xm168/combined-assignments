package com.cooksys.ftd.assignments.jdbc.predef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager, AutoCloseable {

	private Connection connection;
	private String driver;
	private String url;
	private String username;
	private String password;
	
	

	public ConnectionManagerImpl(String driver, String url, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			createConnection();
		}
		return connection;
	}

	private void createConnection() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(url, username, password);
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void close() throws Exception {
		if (connection != null && !connection.isClosed()) {
			connection.close();
			connection = null;
		}
	}

}
