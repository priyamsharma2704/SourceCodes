package jdbcDemo;
import java.sql.*;


public class Main 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://localhost:3306/studentsdb";
		String uname = "root";
		String pass = "admin";
		int id = 2;
		String name = "Sharma";
		String color = "black";
		//String query = "select * from students";
		String query = "insert into students values (?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(query);
		/*ResultSet r = st.executeQuery(query);
		r.next();
		int id = r.getInt("id");
		String name = r.getString("name");
		String color = r.getString("color");
		System.out.println(id + name + color);
		*/
		st.setInt(1, id);
		st.setString(2, name);
		st.setString(3, color);
		int count  = st.executeUpdate();
		
		System.out.println(count + " rows updated");
		
		st.close();
		con.close();
		 
	}

}
