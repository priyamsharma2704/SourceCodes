package sample;

import java.sql.SQLException;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import network.*;

public class MsgService {
	public TextFlow textflow;//tf1 pointer to the first window's TextFlow
	//user id is different for each window.
	Server server;
	//////////////////////////////////////////////////
	final static int serverPort=5000;
	public final String userName="Jack";
	//////////////////////////////////////////////////
	MsgService(TextFlow tf)
	{
		this.textflow=tf;
		server=new Server(serverPort,this);
	}
	public MsgService() {
		// TODO Auto-generated constructor stub
	}
	
	public void send(Text message) throws SQLException//store a new message into the history
	{
		Msg m=new Msg(userName,message.getText(),message.getStyle());
		server.sendMessage(m);
		updateTextFlow(m);
	}
	public synchronized void updateTextFlow(Msg m)//update each TextFlow in both windows.
	{
		textflow.getChildren().addAll(m.getMsgInfo(),m.getMsgContent());		
		
	}
		
}
