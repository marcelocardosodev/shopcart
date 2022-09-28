package shopcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/story","root","admin123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
