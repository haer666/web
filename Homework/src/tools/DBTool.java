package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBTool {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/gb?useUnicode=true&amp;characterEncoding=UTF-8";
	private static final String DBUSER = "root";
	private static final String PASSWORD = "20010130wangzhun";
	// 准锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷佣锟斤拷锟�
	private Connection con;
	
	
	// 直锟接凤拷锟斤拷实锟斤拷锟斤拷锟绞憋拷锟斤拷锟斤拷锟斤拷锟斤拷佣锟斤拷锟�
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		this.con = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		return this.con;
	}
	
	// 锟截憋拷锟斤拷锟接讹拷锟斤拷
	public void close() {
		if (this.con != null) {
			try {
				this.con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
