package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "pmsystem";
		String userName = "root";
		String password = "779920";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {

		// load JDBC driver name
		Class.forName("com.mysql.cj.jdbc.Driver");

		// URL format
		String connectionURL = "jdbc:mysql://localhost:3307/pmsystem";

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
