package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import sample.MainS;
import sample.Msg;
import sample.MsgService;
import sample.MyViewController;

public class Server {

	/*
	 * Step 2 - 1: Creating the data members Here you should have the basic
	 * serversocket, I/O streams. In addition, you need to have two more data
	 * members: (1) A port number variable, which you can declare it as "int"
	 * (2) A variable of Listener, which you will use to receive messages from
	 * the client.
	 */
	public ServerSocket sserver;
	public Socket each_conn;
	public ObjectOutputStream output;
	int port_num;
	MyViewController main; 
	

	
	Listener listener;
	Thread t_s;
	
	public Server()
	{
		
	}
	
	/*
	 * Step 2 - 2: Implementing the constructor of this Server class (1) Assign
	 * the input parameter "_port" to the port number data member (2) Use the
	 * second input parameter "ms" to initialize your Listener data member
	 * -------------------------------------------------------------------------
	 * (3) Assign current server object to the listener member (hint: calling
	 * bindServer())
	 * -------------------------------------------------------------------------
	 * (4) Initialize the ServerSocket by using the port number (5) Call the
	 * start() function to setup streams and listener
	 */
	public Server(int _port, MsgService ms) {
		port_num = _port;
		listener = new Listener(ms);
		
		Runnable r = new Listener(ms);
		t_s = new Thread(listener);
		
		listener.bindServer(this);

		try {
			sserver = new ServerSocket(1234, 100);
			start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Step 2-3: (1) Wait for client's request and step up streams. Here, you
	 * need to pay attention of the input stream, which is a little special.
	 * Because you should assign the input stream to the data member of the
	 * "Listener" class by calling the "bindSocket()" (2) Once the client is
	 * connected, you need to create a thread based on your "Listener" data
	 * member and let it start running
	 * 
	 */
	public void start() {

		try {
			waitRequests();

			setStreams();

			providingService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void providingService() {
		// TODO Auto-generated method stub
		try {
			t_s.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setStreams() throws IOException {
		// TODO Auto-generated method stub
		output = new ObjectOutputStream(each_conn.getOutputStream());
		listener.bindSocket(each_conn);
		System.out.println("Finish setup streams");
	}

	public void waitRequests() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for new clients"); // for you to read
		try {
			each_conn = sserver.accept(); // this function "accept" is a
											// repeating action
											// Inside accept, there is loop
											// This function will never be
											// executed until
											// it receives a request from client
											// Once it receives a client's
											// request
											// it initializes the Socket
			System.out.println("A new client is coming, his IP is: " + each_conn.getInetAddress().getHostAddress());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Step 3: This function is called from the "MsgService" class. The role of
	 * "sendMessage(Msg message) is to send out the Msg message to the client
	 * side by using the outputstream
	 */
	public void sendMessage(Msg message) throws SQLException {
		try {
			
			output.writeObject(message);
			//-------------------------------------
			
			main= new MyViewController();
			
			main.addRecord(message.name,message.content,message.time);
			//--------------------------------------
			output.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
