package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String userName = "vxsdfiiejcyvyh";
	private static String password = "a9ccd3ba600147f26b0f839eca8c6ad888bd9d15a858f73aec3f62aa4923f184";
	private static String connectionURL = "jdbc:postgresql://ec2-54-147-93-73.compute-1.amazonaws.com:5432/d3vob6nleadnvg?sslmode=require";
	private static String driverClass = "org.postgresql.Driver";

	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(connectionURL, userName, password);

			if (conn != null) {

				System.out.println("connected to db..");
			} else {

				System.out.println("connected to db..");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void main(String[] args) {

		DBConnection.getDBConnection();
	}

}