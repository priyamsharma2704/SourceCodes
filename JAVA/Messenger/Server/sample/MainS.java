package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.fabric.Server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import network.Listener;


//The server main class that run the application
public class MainS extends Application {

	
	@Override
	public void start(Stage primaryStage1) {
		try {
			// The GUI part
			Parent root1 = FXMLLoader.load(getClass().getResource("myView.fxml"));
			Scene scene1 = new Scene(root1, 400, 600);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage1.setScene(scene1);
			primaryStage1.setTitle("Messenger1");
			primaryStage1.setX(100);
			primaryStage1.setY(100);
			primaryStage1.show();
			// end of GUI

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void MainS() {

	}

	public static void update() {

	}


	public static void main(String[] args) throws SQLException {
		// Step 3: setup connection
		
		launch(args);

	}

}
