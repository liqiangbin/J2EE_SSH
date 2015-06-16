package shiep.util;
import java.sql.*;
public class DBhelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/support";
	private static String user = "root", pwd = "123456";
	private static Connection con;
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
ex.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			rs = cmd.executeQuery(sql);
			
		} catch (Exception ex) { 
ex.printStackTrace();
		}
		return rs;
	}
	public static void executeUpdate(String sql) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			cmd.executeUpdate(sql);
			con.close();
} catch (Exception ex) {
 ex.printStackTrace();

		}
	}

	public static void closeConnection() {
		try {
	           if(!con.isClosed())
				con.close();
			  } catch (Exception ex) {
			}
		}

	

}
