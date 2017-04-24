package network;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.application.Platform;
import sample.Msg;
import sample.MsgService;

public 
class Listener implements Runnable
{
	ObjectInputStream input; //data member for input stream
	Client client;  //the client which will be used to send out message
	MsgService msgService; //the GUI handle that is used to update the 
	   //message in the history panel
	String s;
	
	public Listener(MsgService ms) {
		// TODO Auto-generated constructor stub
		msgService=ms;
	}
	
	public void bindClient(Client c)
	{
		client=c;
	}
	
	
	/*Step 4 - 1: use the input parameter "socket" to initialize
	 * the input stream variable "input" - which is one of the data member    
	 */
	public void bindSocket(Socket _connection)
	{
		try {
			input = new ObjectInputStream(client.connection.getInputStream());
			System.out.println("In Streams are setup!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/*Step 4 - 2: the main part for receiving messages by using the 
	 * input stream. Since this class is part of a thread (runnable), 
	 * you need to implement the run(). The role of this function here
	 * is to keep receiving messages from the server side by using
	 * the "input" variable. After you receive any message, you need to 
	 * call the "updateGUI()" function to paint the message onto the GUI
	 * 
	 * */
	@Override
	public void run() {
		
		Msg message;
		while(true)
		{
			try 
			{
			message = (Msg) input.readObject();
			System.out.println("Client Receving!");
			System.out.println(message);
			updateGUI(message);

		} catch (Exception e) {
			e.printStackTrace();
		} 

		}
	}

	
	/* This function is used to print the received message onto the
	 * dialog panel 
	 * */
	public void updateGUI(Msg message)
	{

		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				msgService.updateTextFlow(message);
			}
		});
	}

}