# Client_Server-
Client Server Multi-threaded Database Application 

Client/Server application where client and server both has the GUI interface.

The Server interface provides the following operations to the user:
•	Start, using this option the user ables to start the server so that it can receive the client requests and respond to them.
•	Stop, using this option the user ables to shut down the server.

The server application provides the following services to the client application that will be using this server:
•	Accept new information of the customer from the client application and save it to the customer table and provide the confirmation to the client.
•	Provide list of all the customers to the client application by extracting the customer records from the customer table with the given first name received from the client application.
•	Accept the information about the customer from the client application and using this information update the customer record based upon the customer id and provide the confirmation to the client.
•	Able to handle multiple clients.
The client application is able to do the following:
•	Connect, able to connect with the Server application. All the other operations is not available if it is client application is not connected with the server application.
•	Add, accept new information of the customer from the user and send this information to the server application to add the record to the customer table. Before sending this information provide the necessary data validation, like ID is not provided as it is able to generate automatically. It also do the validation for the needed information i.e. it is provided and also in the correct format. The response of the server displayed to the user.
•	Update, accept information of the customer from the user and send this information to the server application to update the record to the customer table for the provided Customer ID. Before sending this information provide the necessary data validation, like ID provides as it required to update the customer record. It also do the validation for the needed information i.e. it is provided and also in the correct format. The response of the server displays to the user. 
•	Find, accept the first name from the user and send this to the server application to find all the customer records with the provided first name and display all the information received from the server in the text area or similar control like JTable, in an appropriate format. If there is no record with the given first name then  displays an appropriate message to the user.
•	Exit, send an appropriate message to the server so that server disconnect the client and client application is terminated.
