package com.quyvd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.quyvd.model.DatabaseConnector;

public class DatabaseConnector {

	public static Connection dbConnect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/SpringMVC", "postgres", "123456");

		if (connection != null) {
			System.out.println("Connected");
		} else {
			System.out.println("Failed!");
		}

		return connection;
	}

	public static void addUser(User user) throws ClassNotFoundException, SQLException {
		// Connect to DB
		Connection conn = DatabaseConnector.dbConnect();

		// Create a Statement obj
		Statement stmt = conn.createStatement();
		String queryInsert = "INSERT INTO users(firstname,lastname,createdate) VALUES ('" + user.getFirstname() + "','"
				+ user.getLastname() + "','" + user.getCreateDate() + "')";
		stmt.executeUpdate(queryInsert);
		conn.close();
		stmt.close();
	}

}
