package jdbcMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Retrive {
	public static void main(String[] args) 
				{
					// TODO Auto-generated method stub
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ab","root","bridgeit");
						PreparedStatement ps=con.prepareStatement("select * from Student");  
						ResultSet rs=ps.executeQuery();  
						while(rs.next())
						{  
							System.out.println(rs.getInt(1)+" "+rs.getString(2));  
						}
						con.close();
					}
						catch (Exception e) {
										// TODO: handle exception
					}
				

				}
	

}
