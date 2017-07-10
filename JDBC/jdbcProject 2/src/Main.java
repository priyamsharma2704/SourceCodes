import java.sql.*;


public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/studentsdb";
		String uname = "root";
		String pass = "admin";
		String query = "Select * from alien";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		
		Statement st = con.createStatement();
		ResultSet r = st.executeQuery(query);
		
		while(r.next()){
			int id = r.getInt("id");
			String name = r.getString("name");
			String color = r.getString("color");
			
			System.out.println("id = " + id + " name = " + name + " color = " + color);
		}
		
		st.close();
		con.close();
		
	}

}
