package data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.Customer;

public class DataIO {
	private Connection conn = null;
	//will establish the connection
	public DataIO() throws ClassNotFoundException, SQLException {
		//loading JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//access path to the database
		String dbURL = "jdbc:oracle:thin:@calvin.humber.ca:1521:grok";
		String userName = "N01419012";
		String pwd = "oracle";
		//establishing the connection
		conn = DriverManager.getConnection(dbURL, userName, pwd);
	}
	//does table exist into database
	public int checkTableCust() throws SQLException {
		//get metadata(info) about tables and other data in the current connection
		DatabaseMetaData dbm = conn.getMetaData();
		//get a description of the table
		ResultSet rst = dbm.getTables(null, null, "CUSTOMER", null);
		int ch = 0;
		//check if the table exist(next() return true or false)
		if(rst.next()) {
			ch = 1;
		}else{
			ch = 0;
		}
		return ch;
	}
	
//	//create table
//	public void createTableCustomer() throws SQLException {
//		//writing SQL statement, we place the column names, type of data, necessary constraints for columns
//		String sqlStm = "Create Table Customer (\n" + 
//				"CUST_ID int PRIMARY KEY, \n" + 
//				"CUST_FIRST varchar (30) not null, \n" +
//				"CUST_LAST varchar (30) not null, \n" +
//				"CUST_PHONE varchar (10), \n" +
//				"CUST_EMAIL varchar (30) not null, \n" +
//				"CUST_STREET varchar (50), \n" +
//				"CUST_CITY varchar (30), \n" +
//				"CUST_PROVINCE varchar (20), \n" +
//				"CUST_POSTALCODE varchar (6) \n )"; 
//		//creating statement in the current connection
//		Statement stm = conn.createStatement();
//		//executing statement
//		stm.execute(sqlStm);
//		//close statement object
//		stm.close();
//	}
	
	//Insert data to the table, parameter is Customer object
	public void insertCustomer(Customer customer) throws SQLException {
		//writing SQL statement, we place value using get methods (call from Customer), value place in column order
		String sqlStm = "Insert into Customer values ( " +
				customer.getCustomerId() + ", '" +
				customer.getFirstName() + "', '" + 
				customer.getLastName() + "', '" + 
				customer.getPhone() + "', '" +
				customer.getEmail() + "', '" +
				customer.getStreet() + "', '" +
				customer.getCity() + "', '" +
				customer.getProvince() + "', '" +
				customer.getPostalCode() + "')";
		//creating statement in the current connection
		Statement stm = conn.createStatement();
		//executing statement
		stm.execute(sqlStm);
		//close statement object
		stm.close();	
	}
	
	//display data from customer table, as a parameter - first name(retrieve from txtbox, which enter user), 
	//it will return the data in arrayList
	public ArrayList<Customer> displayCustomersF(String nameF) throws SQLException{
		//writing SQL select statement
		String sqlStm = "Select * From Customer Where " + 
				"CUST_FIRST='" + nameF + "'";
		//creating statement object
		Statement stm = conn.createStatement();
		//as we use select statement we need to create resultSet object, need to use method executeQuery, as a parameter - sqlStm, 
		//it will return the result
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		while(rst.next()) {
			//create customer object
			Customer customer  = new Customer();
			//using set data what we read using resultSet and getInt/String methods (depends on type of data)
			customer.setCustomerId(rst.getInt(1));
			customer.setFirstName(rst.getString(2));
			customer.setLastName(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostalCode(rst.getString(9));
			//add information to arrayList
			customers.add(customer);
		}
		//close resultSet object
		rst.close();
		//close statement object
		stm.close();
		//return array of customers
		return customers;			
	}	

	//finding the last customer in the Customer table
	public int lastCust() throws SQLException{
		int numb = 0;
		//writing SQL select statement
		String sqlStm  = "Select Max(CUST_ID) From Customer";
		//creating sql statement object
		Statement stm = conn.createStatement();
		//creating resultSet object
		ResultSet rst = stm.executeQuery(sqlStm);
		//will read while it has line
		while(rst.next()) {
			//return the number of last id in the table
			numb = rst.getInt(1);	
		}
		//close resultSet object
		rst.close();
		//close statement object
		stm.close();
		return numb;
	}

	//Displaying the record based on id (which we get using the lastCust method)
	public String[] findRow(int numb) throws SQLException{
		//writing SQL select statement
		String sqlStm = "Select * From Customer Where CUST_ID = " + numb;
		//creating sql statement object
		Statement stm = conn.createStatement();
		//creating resultSet object
		ResultSet rst = stm.executeQuery(sqlStm);
		//create customer object
		String [] customerNew = new String[9];
		while(rst.next()) {
			//add data to customer using resultSet, as a parameter place number of column from which we read the data
			customerNew[0] = Integer.toString(rst.getInt(1));
			customerNew[1] = rst.getString(2);
			customerNew[2] = rst.getString(3);
			customerNew[3] = rst.getString(4);
			customerNew[4] = rst.getString(5);
			customerNew[5] = rst.getString(6);
			customerNew[6] = rst.getString(7);
			customerNew[7] = rst.getString(8);
			customerNew[8] = rst.getString(9);
		}
		//close resultSet object
		rst.close();
		//close statement object
		stm.close();
		return customerNew;	
	}
//updating the record based customer id. as a parameter cust id  and customer object
	public void updateRecord(Customer customer, int custId) throws SQLException {	
		//writing SQL  statement (use the name of columns and get method for setting value)
		String sqlStm =
				"Update customer set " +
				"CUST_FIRST = '" + customer.getFirstName() + "', " + 
				"CUST_LAST = '" + customer.getLastName() + "', " + 
				"CUST_PHONE = '" + customer.getPhone() + "', " + 
				"CUST_EMAIL = '" + customer.getEmail() + "', " + 
				"CUST_STREET = '" + customer.getStreet() + "', " + 
				"CUST_CITY = '" + customer.getCity() + "', " + 
				"CUST_PROVINCE = '" + customer.getProvince() + "', " + 
				"CUST_POSTALCODE = '" + customer.getPostalCode() + "' " + 
				"WHERE CUST_ID = " + custId + " ";
		//creating sql statement object
		Statement stm = conn.createStatement();
		//executing statement
		stm.execute(sqlStm);
		//close statement
		stm.close();
	}
}
