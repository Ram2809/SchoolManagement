package com.revature.curriculummanagement.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() throws IOException, SQLException {
		Connection con = null;
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\RamkumarC\\Documents\\workspace-spring-tool-suite-4-4.11.0.RELEASE\\SchoolManagement\\src\\main\\java\\jdbc.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String URL = properties.getProperty("url");
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		con = DriverManager.getConnection(URL, userName, passWord);
		return con;
	}
}
