package vn.iotstar.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionSQL_22110446 {
	private final String servername = "localhost";
	private final String dbname = "KTGiuaKy";
	private final String user = "sa";
	private final String password = "123456";
	private final String port_num = "1433";
	public Connection GetConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://"+servername+":"+port_num+";databaseName="+dbname+ ";encrypt=true;trustServerCertificate=true;";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		try {
			Connection conn = new DBConnectionSQL_22110446().GetConnection();
			System.out.println(conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
