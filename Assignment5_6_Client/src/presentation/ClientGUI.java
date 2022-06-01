package presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import data.Validator;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextField;


import business.Customer;
import connect.ConnectServer;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame {
	private JTextField textField;
	//new ConnectServer object
	ConnectServer connServ = null;
	
	private JTextField txtCustID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtdress;
	private JTextField txtCity;
	private JTextField txtPostalCode;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public ClientGUI() {

		getContentPane().setBackground(new Color(240, 240, 240));
		setBackground(new Color(220, 220, 220));
		setFont(new Font("Dialog", Font.BOLD, 25));
		getContentPane().setLayout(null);
		
		this.setTitle("Client GUI");
		this.setBounds(270, 300, 1083, 652);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lblCustomertId = new JLabel("Customer ID");
		lblCustomertId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCustomertId.setBounds(50, 22, 138, 40);
		getContentPane().add(lblCustomertId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFirstName.setBounds(50, 73, 138, 40);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLastName.setBounds(471, 73, 99, 40);
		getContentPane().add(lblLastName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhone.setBounds(50, 220, 87, 42);
		getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(471, 220, 87, 42);
		getContentPane().add(lblEmail);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStreet.setBounds(50, 124, 138, 42);
		getContentPane().add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCity.setBounds(50, 171, 87, 42);
		getContentPane().add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProvince.setBounds(471, 171, 99, 42);
		getContentPane().add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPostalCode.setBounds(471, 124, 138, 42);
		getContentPane().add(lblPostalCode);
		
		txtCustID = new JTextField();
		txtCustID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustID.setColumns(10);
		txtCustID.setBounds(176, 27, 190, 33);
		getContentPane().add(txtCustID);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(176, 78, 250, 33);
		getContentPane().add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLastName.setColumns(10);
		txtLastName.setBounds(610, 78, 250, 33);
		getContentPane().add(txtLastName);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(176, 226, 190, 33);
		getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(610, 226, 190, 33);
		getContentPane().add(txtEmail);
		
		txtdress = new JTextField();
		txtdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdress.setColumns(10);
		txtdress.setBounds(176, 130, 250, 33);
		getContentPane().add(txtdress);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBounds(176, 177, 224, 33);
		getContentPane().add(txtCity);
		
//Fill combobox from Province
		JComboBox cmbProvince = new JComboBox();
		cmbProvince.setModel(new DefaultComboBoxModel(new String[] {"ON", "QC", "NS", "NB", "MB", "BC", "PE", "SK", "AB", "NL"}));
		cmbProvince.setBounds(610, 179, 190, 33);
		getContentPane().add(cmbProvince);
		
		txtPostalCode = new JTextField();
		txtPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(610, 130, 190, 33);
		getContentPane().add(txtPostalCode);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.setBounds(30, 300, 1000, 280);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrpane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrpane);
		getContentPane().add(panel);
		
//connect to the server	
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adding  try catch to handle with the exceptions
				try {
					//ConnectServer object with the server
					connServ = new ConnectServer("127.0.0.1", 10000);
					System.out.println("connect");
					JOptionPane.showMessageDialog(null, "You have connected to the Server" );
				} catch (UnknownHostException e3) {
					// TODO Auto-generated catch block
//					e3.printStackTrace();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
//					e3.printStackTrace();
				}
			}
		});

		buttonGroup.add(btnConnect);
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConnect.setBounds(902, 26, 121, 34);
		getContentPane().add(btnConnect);
				
//SAVE New Customer into table
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isFirstName(txtFirstName, "First Name")) {
					String firstName = txtFirstName.getText();
				
				if(Validator.isLastName(txtLastName, "Last Name")) {
					String lastName = txtLastName.getText();
				
				if(Validator.isPhone(txtPhone, "Phone")) {
					String phone = txtPhone.getText();	
				
				if(Validator.isEmail(txtEmail, "Email")) {
					String email = txtEmail.getText();

				if(Validator.isStreet(txtdress, "Street")) {
					String street = txtdress.getText();
				
				if(Validator.isCity(txtCity, "City")) {		
					String city = txtCity.getText();
						
				if(Validator.isPostalCode(txtPostalCode, "Postal Code")) {		
					String postalCode = txtPostalCode.getText();
					//getting information to sending to the server
					Customer customer = new Customer();
					customer.setFirstName(txtFirstName.getText());
					customer.setLastName(txtLastName.getText());
					customer.setPhone(txtPhone.getText());
					customer.setEmail(txtEmail.getText());
					customer.setStreet(txtdress.getText());
					customer.setCity(txtCity.getText());
					customer.setProvince(cmbProvince.getItemAt(cmbProvince.getSelectedIndex()).toString());
					customer.setPostalCode(txtPostalCode.getText());
					try {
						//calling the method from ConnectServer class to send data to the server for adding new customer
						connServ.insert(customer);
					} catch (IOException e1) {
//						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The customer is saved" );	
			}
				}}}}}}}
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.setBounds(902, 73, 120, 34);
		getContentPane().add(btnAdd);
		
//UPDATE row based on customer id	
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Validator.isCustIDIsNull(txtCustID, "The Customer ID is empty.")) {
					String CustID = txtCustID.getText();
					
					if(Validator.isFirstName(txtFirstName, "First Name")) {
						String firstName = txtFirstName.getText();
					
					if(Validator.isLastName(txtLastName, "Last Name")) {
						String lastName = txtLastName.getText();
					
					if(Validator.isPhone(txtPhone, "Phone")) {
						String phone = txtPhone.getText();	
					
					if(Validator.isEmail(txtEmail, "Email")) {
						String email = txtEmail.getText();

					if(Validator.isStreet(txtdress, "Street")) {
						String street = txtdress.getText();
					
					if(Validator.isCity(txtCity, "City")) {		
						String city = txtCity.getText();
							
					if(Validator.isPostalCode(txtPostalCode, "Postal Code")) {		
					String postalCode = txtPostalCode.getText();
					
					int custId = (Integer.parseInt(txtCustID.getText()));
					Customer customer = new Customer();
					customer.setCustomerId(custId);
					customer.setFirstName(txtFirstName.getText());
					customer.setLastName(txtLastName.getText());
					customer.setPhone(txtPhone.getText());
					customer.setEmail(txtEmail.getText());
					customer.setStreet(txtdress.getText());
					customer.setCity(txtCity.getText());
					customer.setProvince(cmbProvince.getItemAt(cmbProvince.getSelectedIndex()).toString());
					customer.setPostalCode(txtPostalCode.getText());
					try {
						//calling the method from ConnectServer class to send data to the server for updating
						connServ.update(customer);
						System.out.println("disconnect");
					} catch (IOException e1) {
//						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The customer is updated");
		
		}}}}}}}}}	
	});
		buttonGroup.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(902, 163, 121, 34);
		getContentPane().add(btnUpdate);
		
//DISPLAY row(s) based on entering first		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Validator.isFirstNameLastNameNull(txtFirstName, txtLastName, "The First and Last Name are empty")) {
					String FirstName = txtFirstName.getText();
					if(!(txtFirstName.getText().isEmpty())) {
						//getting name which user provides
						String nameF = txtFirstName.getText();					
						Customer customer = new Customer();
						customer.setFirstName(txtFirstName.getText());	
						try {
							//creating the list of data which server extract from the table, calling from ConnectServer class
							List<Customer> cust = connServ.find(customer);
							//printing data into textarea
							for(Customer c : cust) {
								txtArea.append(c.toString() + "\n");
							}
						} catch (IOException e1) {
						}
					}
			}}
		});
		
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFind.setBounds(902, 118, 121, 34);
		getContentPane().add(btnFind);
			
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//calling the method close() to close connection
				connServ.close();
				} catch (IOException e1) {
				}
				JOptionPane.showMessageDialog(null, "You have disconnected to the Server" );
//				 setVisible(false);
				 dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(902, 208, 121, 34);
		getContentPane().add(btnExit);
		
//CLEAR all txt fields		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					txtCustID.setText("");
					txtFirstName.setText("");
					txtLastName.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					txtdress.setText("");
					txtCity.setText("");
					txtPostalCode.setText("");
					cmbProvince.getItemAt(cmbProvince.getSelectedIndex()).toString();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(902, 253, 121, 34);
		getContentPane().add(btnClear);	
	}
	}
