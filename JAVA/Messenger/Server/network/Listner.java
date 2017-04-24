package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import sample.MainS;
import sample.Msg;
import sample.MsgService;
import sample.MyViewController;

public class Listener implements Runnable {
	ObjectInputStream input; // data member for input stream
	Server server; // the server which will be used to send out message
	public MsgService msgService; // the GUI handle that is used to update the
							// message in the history panel
	boolean flag = true;
	String s;

	public Listener(MsgService ms) {
		msgService = ms;
	}
	
	

	public void bindServer(Server _server) {
		server = _server;
	}

	/*
	 * Step 4 - 1: use the input parameter "socket" to initialize the input
	 * stream variable "input" - which is one of the data member
	 */
	public void bindSocket(Socket socket) {
		try {
			input = new ObjectInputStream(server.each_conn.getInputStream());
			System.out.println("In Streams are setup!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Step 4 - 2: the main part for receiving messages by using the input
	 * stream. Since this class is part of a thread (runnable), you need to
	 * implement the run(). The role of this function here is to keep receiving
	 * messages from the client side by using the "input" variable. After you
	 * receive any message, you need to call the "updateGUI()" function to paint
	 * the message onto the GUI
	 * 
	 */
	@Override
	public void run() {

		Msg message;
		
		while (true)
		{
			
				try {
					message = (Msg) input.readObject();
					System.out.println("Server Receving!");
					System.out.println(message);
					updateGUI(message);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		

	}
	
	

	/*
	 * This function is used to print the received message onto the dialog panel
	 */
	public void updateGUI(Msg message) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				msgService.updateTextFlow(message);
				
			}
		});
	}
	
	
}
