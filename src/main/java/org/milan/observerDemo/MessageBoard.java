package org.milan.observerDemo;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class MessageBoard  {
	
	private String url="jdbc:derby:C:\\Users\\IBM_ADMIN\\MyDB";
	private String username="admin";
	private String password="admin";
	private Connection conn;
	public static void main(String[] args) {
	new MessageBoard().dbConnection();
	}
	public void dbConnection(){
		String s="select * from test where username like 'test%'";
		try(Connection conn=DriverManager.getConnection(url,username,password);Statement st=conn.createStatement()){
			ResultSet rs=st.executeQuery(s);
			if(rs==null){
				System.out.println("test");
			}
			else{
				System.out.println(rs.getString(1));
				System.out.println("true");
			}
			//rs.d
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}	
	
	
}
