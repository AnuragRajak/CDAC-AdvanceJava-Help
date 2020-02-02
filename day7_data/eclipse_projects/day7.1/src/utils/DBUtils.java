package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	// add a static method to ret DB conn
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		if (cn == null) {
			String url = "jdbc:mysql://localhost:3306/test_acts";
			// mandatory in Java EE
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, "root", "root");
		}
		return cn;
	}
	//add a static method to nullify connection
	public static void resetConn()
	{
		System.out.println("resetting cn to null");
		cn=null;
	}
}
