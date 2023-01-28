package DataAccessObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBUtil;
import PlainOldJavaObject.LoginInfo;

public class LoginDAO {

	// method isUserValid return variable type boolean
	// get one param LoginInfo
	public static boolean isUserValid(LoginInfo userDetails) {

		boolean validStatust = false;
		try {
			// create connection
			Connection conn = DBUtil.getConnection();
			// create query
			Statement stm = conn.createStatement();
			// create object Result
			ResultSet rs = stm.executeQuery("SELECT * FROM login_info WHERE user_name = '" + userDetails.getUserName()
					+ "' AND password = '" + userDetails.getPassword()+"'");
			while (rs.next()) {
				// if one record in database is record true
				validStatust = true;
			}

			// close connection
			DBUtil.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return validStatust;

	}
}
