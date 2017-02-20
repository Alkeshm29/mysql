package jdbcMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MysqlDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ab", "root", "bridgeit");

				System.out.println("1.Display 2.Insert 3.Delete 4.Update");
				Scanner sc = new Scanner(System.in);
				int ch = sc.nextInt();

				switch (ch) {
				case 1:

					PreparedStatement ps = con.prepareStatement("select * from Student");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " " + rs.getString(2));
					}
					con.close();

					break;
				case 2:
					PreparedStatement ps2 = con.prepareStatement("insert into Student values(?,?)");
					ps2.setInt(1, 5);
					ps2.setString(2, "f");
					int i = ps2.executeUpdate();
					System.out.println(i + "Record is inserted");

					break;
				case 3:
					PreparedStatement ps3 = con.prepareStatement("Delete form table where id=?");
					ps3.setInt(1, 3);
					i = ps3.executeUpdate();
					System.out.println(i + "Record Deleted");
					con.close();

					break;
				case 4:
					PreparedStatement ps4 = con.prepareStatement("update Student set name=? where id=?");
					ps4.setString(1, "t");
					ps4.setInt(2, 3);
					i = ps4.executeUpdate();
					System.out.println(i + "Record Update");
					con.close();
					break;

				default:
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}