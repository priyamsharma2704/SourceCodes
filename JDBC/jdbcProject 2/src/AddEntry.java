import java.sql.*;

public class AddEntry {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/studentsdb";
		String uname = "root";
		String pass = "admin";
		String query = "insert into alien values (?,?,?,?,?);";
		//---------------------------------
		int id = 1;
		String name = "shubham";
		String color = "black";
		String fname = "shubham";
		String lname = "sharma";
		//---------------------------------
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, name);
		st.setString(3, color);
		st.setString(4, fname);
		st.setString(5, lname);
		
		int count = st.executeUpdate();
		
		System.out.println(count + " rows updated");
	}

}
