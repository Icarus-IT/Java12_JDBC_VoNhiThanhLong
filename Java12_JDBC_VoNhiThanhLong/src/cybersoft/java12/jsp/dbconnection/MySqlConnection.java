package cybersoft.java12.jsp.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static String url = "jdbc:mysql://localhost:3306/customerdb";
	private static String username = "root";
	private static String password = "123456LoUgo!!!";

	public static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can not find MySQL Driver!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can not connect to database due to: invalid url or invalid credential");
		}
		return connection;
	}
}
