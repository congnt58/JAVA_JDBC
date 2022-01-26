package com.vti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public final static String DATABASE_NAME_STRING = "Testing_System_1";

	public static final String URL_DB = "jdbc:mysql://localhost:3306/" + DATABASE_NAME_STRING
			+ "?autoReconnect=true&useSSL=false&characterEncoding=latin1";

	public static final String USER_DB = "root";
	public static final String PASSWORD = "root";

	private JDBCUtil() {

	}
	private static JDBCUtil intance;
	private Connection connection;

	public static JDBCUtil getIntance() {
		if (intance == null) {
			intance = new JDBCUtil();
		}
		return intance;
	}

	public Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD);
		}
		return connection;
	}

	public void removeIntance() throws SQLException {
		closeConnection();
		intance = null;
	}

	public Statement getStatement() throws SQLException {
		return getConnection().createStatement();
	}

	public PreparedStatement getPreparedStatement(String sqlQuery) throws SQLException {
		PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery);
		return preparedStatement;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		connection = null;
	}

}
