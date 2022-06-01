package presentation;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ServerGUI extends JFrame {

	Server server = new Server();
	Thread serverThread = new Thread(server);
	
	public ServerGUI() {
		getContentPane().setBackground(new Color(240, 240, 240));
		setBackground(new Color(220, 220, 220));
		setFont(new Font("Dialog", Font.BOLD, 25));
		getContentPane().setLayout(null);
		
		this.setTitle("Server GUI");
		this.setBounds(270, 300, 450, 270);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(34, 76, 372, 131);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			serverThread.start();
			textArea.append("Server starts \n");
			}
		});
		btnNewButton.setBounds(35, 31, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Server closes");
				try {
					server.stopListener();
					System.exit(0);
				} catch (IOException e1) {

				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStop.setBounds(295, 31, 89, 23);
		getContentPane().add(btnStop);
	}
}
