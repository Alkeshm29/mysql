package jdbcMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DeleteDemo {
			public static void main(String[] args) 
			{
				// TODO Auto-generated method stub
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ab","root","bridgeit");
					PreparedStatement ps=con.prepareStatement("delete from Student where id=?");  
				
					ps.setInt(1,3);
					int i=ps.executeUpdate();
					System.out.println(i+"Record Deleted");
					con.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}


}
