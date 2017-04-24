package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class searchController implements Initializable,EventHandler<ActionEvent> {
	
	public AnchorPane aPane = new AnchorPane();
	public Label kw = new Label();
	public TextField tf;
	public Button srch = new Button();
	public TextArea ta = new TextArea();
	//Text t;
	public String s = new String("priyam");
	public String s2 = new String();
	MyViewController mvc = new MyViewController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
			
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		s=tf.getText().toString();
		try {
			s2=mvc.search(s);
			show(s2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void show(String w)
	{
		ta.setText(w+"\n");
	}
	
}
