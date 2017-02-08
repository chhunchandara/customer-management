package servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class CLS_MYSQLDB {
	
	
	public Connection get_connection() throws Exception{
		String dbURL = "jdbc:mysql://localhost:3306/customer-managment?zeroDateTimeBehavior=convertToNull";
		String username = "root";
		String password = "MYSECRET";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		return conn;
	}
	
}
