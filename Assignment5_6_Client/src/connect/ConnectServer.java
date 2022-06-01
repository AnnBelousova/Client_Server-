package connect;

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
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import business.Customer;
import communication.Request;
import communication.TypeRequest;


public class ConnectServer {
	//creating the objects accordingly 
	Socket socket = null;
	BufferedWriter out;
	BufferedReader in;

	//constructor to ConnectServer object to establish communication with server
	public ConnectServer(String adress, int port) throws UnknownHostException, IOException {
		socket = new Socket(adress, port);
		//building dataInputStrean  and OutputStream, as we need to communicate through the socket 
		//we will use the method getInputStream()), getOutputStream()
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	
	}
	//creating method for server to inserting new customer to the table
	public Customer insert(Customer customer) throws IOException {
		//as we created the class Request, we need to create the object of it
		//as a parameter we have the type of request(for telling the server which method it should use) 
		//and customer object
		Request request = new Request(TypeRequest.insert, customer);
		System.out.println("insertOUT");
		//here we will write the data
		out.write(request.toString());
		//flush method will flushes the stream
		out.flush();
		return null;	
	}
	//creating method for server to updating customer into the table
	public Customer update(Customer customer) throws IOException {
		System.out.println("update");
		Request request = new Request(TypeRequest.update, customer);
		out.write(request.toString());
		out.flush();
		return null;	
	}
	//creating method for server to finding customer into the table
	public List<Customer> find(Customer customer) throws IOException {
		System.out.println("find");
		Request request = new Request(TypeRequest.find, customer);
		out.write(request.toString());
		out.flush();
		//creating the stream which we will read from the server
		String result = in.readLine();
		System.out.println(result);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		result = result.substring(1);
		//parse the data to provide the readable format
		String[] str = result.split(",");
		for(int i= 0; i<str.length; i++) {   
			String[] strRes = str[i].split("\\s");
			Customer customersN = new Customer();
			int custId = Integer.parseInt(strRes[0]);
			customersN.setCustomerId(custId);
			customersN.setFirstName(strRes[1]);
			customersN.setLastName(strRes[2]);
			customersN.setPhone(strRes[3]);
			customersN.setEmail(strRes[4]);
			customersN.setCity(strRes[5]);
			customersN.setStreet(strRes[6]);
			customersN.setProvince(strRes[7]);
			customersN.setPostalCode(strRes[8]);
			customers.add(customersN);
		}	
		return customers;	
	}
	//method to close connection
	public void close() throws IOException {
		Request requestt = new Request(TypeRequest.exit);
		out.write(requestt.toString());
		out.flush();
		in.close();
		out.close();
		//closing the socket
		socket.close();
	}
}
