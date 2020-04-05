package bs;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Sqliteconnection {
	public static Connection Connectiondb(){
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/users","root", "");
		JOptionPane.showMessageDialog(null,"Database is Connected!");
		
		return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Do not connect to DB - Error:"+e);
			return null;
		}
		
	}
}
