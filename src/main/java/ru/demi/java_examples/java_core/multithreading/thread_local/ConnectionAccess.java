package ru.demi.java_examples.java_core.multithreading.thread_local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by demi
 * on 23.07.15.
 */
public class ConnectionAccess {
	public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/world?user=root&password=pMySqL@Sp";

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {

		public Connection initialValue() {
			try {
				return DriverManager.getConnection(JDBC_URL);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};

	public static Connection getConnection() {
		return connectionHolder.get();
	}
}
