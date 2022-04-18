package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbctest {
	
	public static void main(String[] args) {
		System.out.println("JDBC Test");
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
		 connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","DEMO");
		 statement = connection.createStatement();
		
	      int result = statement.executeUpdate("insert into account values(4,'kavi','Kj',9000)");
		System.out.println("Number of rows inserted"  + result);
		
		

			//int result = statement.executeUpdate("update account set balance=13000 where accno=2");
		     //System.out.println("Number of row updated"  + result);
		     
//
//		 	int result = statement.executeUpdate("delete from account where accno=3");
//		 	   System.out.println("Number of rows deleted"  + result);
		
		 rs = statement.executeQuery("select * from account");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ ". "+ rs.getString(2)+". "+ rs.getString(3)+ ".Balance= "+ rs.getInt(4));
		}
		
	
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		}
		
	}

