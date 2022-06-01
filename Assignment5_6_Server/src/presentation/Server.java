package presentation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	//declaration of a Socket object
	Socket socket;
	//port for communication with client
	int port = 10000;
	//server object of a Server class
	ServerSocket server = null;
//
	Thread tr;
	boolean run = true;
	@Override
	public void run() {
		try {
			//creating the server object, as a parameter is port
			server = new ServerSocket(port);
			//while loop will allow to connect multiple clients to a single server at the same time
			while(run) {
				//using the accept() method the server will wait the client
				//(we are getting the connecting from the client)
					Socket socket = server.accept();
					System.out.println("Server is running and waiting from client.");
				//creating new object of Client (task class)
					Client client = new Client(socket);
					//creating the new thread for each connection, as a parameter we place the client(task for thread)
					tr = new Thread(client);
					System.out.println("New client is connected");
					//start method to start the tread
					tr.start();
					server.close();
			}		
		} catch (IOException e) {
		}
	}
	//method to stop server
	public void stopListener() throws IOException, InterruptedException {
		run = false;
		server.close();
	}
}
