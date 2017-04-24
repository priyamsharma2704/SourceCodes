package network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import sample.MainC;
import sample.Msg;
import sample.MsgService;
import sample.MyViewController;

public class Client {
	
	/*Step 2 - 1: Creating the data members 
	 * 	Here you should have the basic socket, I/O streams.
	 *  In addition, you need to have two more data members:
	 *  (1) A port number variable, which you can declare it as "int"
	 *  (2) A server_ip variable, which can be declared as "String" 
	 *  (3) A variable of Listener, which you will use to receive messages from
	 *  the server. 
	 * */
	Socket connection;
	ObjectOutputStream output;
	int port_num;
	String server_ip = "127.0.0.1";
	Listener listener;
	Thread t_c;
	MyViewController main;
	
		
	
	
	
	/*Step 2 - 2: Implementing the constructor of this Client class
	 * (1) Assign the input parameter "ip" to the server_ip data member
	 * (2) Assign the input parameter "_port" to the port number data member 
	 * (3) Use the third input parameter "ms" to initialize your Listener data member
	 * (4) Assign current client object to the listener member (hint: calling bindServer())
	 * (5) Call the start() function to setup streams and listener
	 */
	public Client(String ip,int _port,MsgService ms)
	{
		server_ip="127.0.0.1";
		port_num= _port;
		listener=new Listener(ms);
		
		Runnable r = new Listener(ms);
		t_c = new Thread(listener);
		
		listener.bindClient(this);
		start();

	}

	
	/*Step 2-3: 
	 * (1) Send request to the server and step up streams.
	 * 	   Here, you need to pay attention of the input stream, which is
	 *     a little special. Because you should assign the input stream to
	 *     the data member of the "Listener" class by calling the "bindSocket()"
	 * (2) Once the server is connected, you need to create a thread 
	 *     based on your "Listener" data member and let it start running 
	 *  
	 * */
	public void start()
	{	
		
		try {
			
			sendRequest();
			
			setStreams();
			
			havingService();
			
		} catch (Exception eof) {
			// TODO Auto-generated catch block
			eof.printStackTrace();
		}
	}
	
	public void havingService() {
		// TODO Auto-generated method stub
		t_c.start();
		
	}


	public void setStreams() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Port " + connection.getPort());
		System.out.println("Start streams");
		
		//The streams should be associated with the Socket (connection)
		output = new ObjectOutputStream(connection.getOutputStream());
		listener.bindSocket(connection);
		System.out.println("Finish setup streams");
	}


	public void sendRequest() throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Sending request to the server!");
		
		//construct the socket (IP, port)
		connection = new Socket(InetAddress.getByName(server_ip), 1234);
		
		System.out.println("Now, you are connected to the server: " 
		+ connection.getInetAddress().getHostName());
		
	}


	/*Step 3: 
	 * This function is called from the "MsgService" class.
	 * The role of "sendMessage(Msg message) is to send out the Msg message
	 * to the server side by using the outputstream
	 * */
	public void sendMessage(Msg message) throws SQLException
	{
		try {
			output.writeObject(message);
			main = new MyViewController();
			main.addRecord(message.name,message.content,message.time);
			output.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



