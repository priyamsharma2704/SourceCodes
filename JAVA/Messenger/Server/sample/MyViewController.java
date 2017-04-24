package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.Timer;



public class MyViewController implements Initializable,EventHandler<ActionEvent> {
	
	
	public Text content;
	 
	
	private static MsgService msgService;//includes message storage and textflow update operation.
	public static Msg m;
	static String word1;
	static String word2;
	static String word3;
	
	@FXML
	private BorderPane bPane;
	@FXML
	private ImageView userIcon;
	@FXML
	public TextFlow textflow;
	@FXML
	public  TextArea textarea;
	@FXML 
	private ComboBox<String> fontColor;
	@FXML
	private ComboBox<String> fontSize;
	@FXML
	private ComboBox<String> bgColor;
	//static TextArea textarea2;
	//static searchController sc = new searchController();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		msgService=new MsgService(textflow);
		
		bgColor.setValue("blue");//different color for different user window.
			
		fontColor.setValue("black");//set default fontColor
		
		//set default style
		textarea.setStyle("-fx-text-fill:"+fontColor.getValue()+
				";-fx-font-size:"+fontSize.getValue());
		//set background color
		bPane.setStyle("-fx-background-color:"+bgColor.getValue()); 
		
		//----------
		Connection conn = getConnection();
		
		try {
			createTable();
			showHistory();		
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//----------
		

	}
	
	//----
	
	public static String search(String word) throws SQLException
	{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT USER,MESSAGE,TIME FROM chathistory.record WHERE MESSAGE LIKE'%"+word+"%'; ";
		ResultSet rs = stmt.executeQuery(sql);
		String word4="";
		while(rs.next())
		{
			word2 = rs.getString("USER");
			word1 = rs.getString("TIME");
			word3 = rs.getString("MESSAGE");
			word4 = word4+word1+"\n"+word2+" : "+word3+"\n";
			System.out.println(word1+"\n"+word2+" : "+word3);
			}
		stmt.close();
		conn.close();
		return word4;
	}

	public static void dropTable() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		String sql = "DROP TABLE  RECORD";

		stmt.executeUpdate(sql);
		System.out.println("Table is dropped successfully");

		stmt.close();
		conn.close();

	}
	static PreparedStatement ps;

	public void addRecord(String name, String message, String time) throws SQLException {
		Connection conn = getConnection();
		ps = conn.prepareStatement("INSERT INTO RECORD  (`USER`, `MESSAGE`, `TIME`)" + "VALUES(?,?,?)");

		//ps.setString(1, "1");
		ps.setString(1, name);
		ps.setString(2, message);
		ps.setString(3, time);
		ps.executeUpdate();
		

	}
	public static void createTable() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS RECORD"
				+ "(ID INT NOT NULL AUTO_INCREMENT," 
				+ "USER VARCHAR(100),"
				+ "MESSAGE VARCHAR(100)," 
				+ "TIME TIMESTAMP," 
				+ "PRIMARY KEY(ID))";

		stmt.executeUpdate(sql);
		System.out.println("Table is created successfully");

		stmt.close();
		conn.close();
	}
	public static void showHistory() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM RECORD ";
		ResultSet rs = stmt.executeQuery(sql);
		
		//use while loop to traverse all the records
		while(rs.next())
		{
			int id =rs.getInt("ID");
			
			String name = rs.getString("USER");
			String message = rs.getString("MESSAGE");
			String time = rs.getString("TIME");
			int x= 0;
			m = new Msg(name,message,time,x);
			msgService.updateTextFlow(m);
			String hist = name+message+time;
		
			
			System.out.println(id + "\t" + name+ "\t"+ message+ "\t"+ time );
			
			
		}
		rs.close();
		stmt.close();
		conn.close();
		
	}
	public static Connection getConnection() {

		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/chathistory";
			String username = "root";
			String password = "hayabusa";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);

			System.out.println("Connection is established");
			return conn;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	//-----------------------------------
	

	public void sendFuc() throws SQLException{
		
		//convert string to a Text object
		content=new Text(textarea.getText()+"\n");
		
		//set the Text with user defined style. 
		content.setStyle("-fx-fill:"+fontColor.getValue()+
				";-fx-font-size:"+fontSize.getValue());
		
		//push current message into msg_history.
		msgService.send(content);
		textarea.clear();
	}
	
		
	public void clearFuc(){
		textflow.getChildren().clear();
		
	}   
	public void changeFont(){
		//change the font style setting
		textarea.setStyle("-fx-text-fill:"+fontColor.getValue()+
				";-fx-font-size:"+fontSize.getValue());
	}


	public void changeBG(){
		//change the background style setting
		bPane.setStyle("-fx-background-color:"+bgColor.getValue());
	}


	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search.fxml"));
	                Parent root1 = (Parent) fxmlLoader.load();
	                Stage stage = new Stage();
	                stage.setScene(new Scene(root1));  
	                stage.show();
	        } catch(Exception e) {
	           e.printStackTrace();
	          }
		
	}
	

}
