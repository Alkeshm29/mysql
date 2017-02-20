package jdbcMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ab", "root", "bridgeit");
			PreparedStatement ps = con.prepareStatement("update Student set name=? where id=?");
			ps.setString(1, "t");
			ps.setInt(2, 3);
			int i = ps.executeUpdate();
			System.out.println(i + "Record Update");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
