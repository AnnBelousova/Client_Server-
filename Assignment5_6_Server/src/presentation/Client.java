package presentation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import business.Customer;
import communication.Request;
import data.DataIO;
//task class which is implement Runnable interface
public class Client implements Runnable{
//socket object
	Socket socket;
//declaration of BufferReader and BufferWriter(will read the data and receive result to client)
	BufferedReader objectInput;
	BufferedWriter  objectOutput;
//Constructor to Client object (Client task class)
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		objectInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		objectOutput =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
//implementing the run method 
	@Override
	public void run() {
		//implementing the explanation to the system how to run Client task
		while(true) {
			DataIO dIO;
			try {
				dIO = new DataIO();
				String request = objectInput.readLine();			
//				System.out.println(request);
				String[] str = request.split("\\s");			
				do {
				if(str[0].equals("insert")) {
				try {
					Customer customer = new Customer();
					int custId = dIO.lastCust()+1;
					customer.setCustomerId(custId);
					customer.setFirstName(str[2]);
					customer.setLastName(str[3]);
					customer.setPhone(str[4]);
					customer.setEmail(str[5]);
					customer.setCity(str[7]);
					customer.setStreet(str[6]);
					customer.setProvince(str[8]);
					customer.setPostalCode(str[9]);
					dIO = new DataIO();
					dIO.insertCustomer(customer);
					
//					System.out.println(customer);		
				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
				} catch (SQLException e) {
//					e.printStackTrace();
				}
				}
				
				if(str[0].equals("update")) {
				try {
					dIO = new DataIO();
					System.out.println("update");
					Customer customer = new Customer();
					int custId = Integer.parseInt(str[1]);
					customer.setFirstName(str[2]);
					customer.setLastName(str[3]);
					customer.setPhone(str[4]);
					customer.setEmail(str[5]);
					customer.setCity(str[7]);
					customer.setStreet(str[6]);
					customer.setProvince(str[8]);
					customer.setPostalCode(str[9]);
					dIO.updateRecord(customer, custId);
//					System.out.println(custId);
					
				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
				} catch (SQLException e) {
//					e.printStackTrace();
				}
				}
				
				if(str[0].equals("find")) {
					try {
						dIO = new DataIO();					
						System.out.println("find");
						Customer customer = new Customer();
						String nameF = str[2];

						String requestOut = objectOutput.toString();
						System.out.println(requestOut);
						String[] strOut = requestOut.split("\\s");
						
						ArrayList<Customer> customers =dIO.displayCustomersF(nameF);
						System.out.println(customers);
						objectOutput.write(customers.toString());
						objectOutput.flush();
						
					} catch (ClassNotFoundException e) {
//						e.printStackTrace();
					} catch (SQLException e) {
//						e.printStackTrace();
					}
					}
				}while(str[0].equals("exit")); // condition for stopping connection
				
			}catch(IOException | SQLException e) {
//	            e.printStackTrace();
			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
			}
		}
	}
}

