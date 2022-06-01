package data;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class Validator {

		// txtFirstName from CustomerGUI
			public static boolean isFirstName(JTextComponent c, String title ) {
				if ((c.getText().length() == 0) || (c.getText().length() > 30)) {
					showMessage1(c, title + " is a requared field. \nPlease enter no more than 30 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage1(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "First Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		// txtLastName from CustomerGUI
			public static boolean isLastName(JTextComponent c, String title ) {
				if ((c.getText().length() == 0) || (c.getText().length() > 10)) {
					showMessage2(c, title + " is a requared field. \nPlease enter no more than 30 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage2(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "Last Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		//txtPhone from CustomerGUI
			public static boolean isPhone(JTextComponent c, String title ) {
				if ((c.getText().length() == 0) || (c.getText().length() > 10)) {
					showMessage3(c, title + " is a requared field. \nPlease enter no more than 10 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage3(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "Phone Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}	
			
		// txtEmail from CustomerGUI
			
			public static boolean isEmail(JTextComponent c, String title ) {
				if ((c.getText().length() == 0) || (c.getText().length() > 30)) {
					showMessage4(c, title + " is a requared field. \nPlease enter no more than 30 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage4(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "Email Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		// txtStreet from CustomerGUI
			
			public static boolean isStreet(JTextComponent c, String title ) {
				if ((c.getText().length() == 0) || (c.getText().length() > 50)) {
					showMessage5(c, title + " \nPlease enter no more than 50 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage5(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "Street Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		// txtCity from CustomerGUI
			
			public static boolean isCity(JTextComponent c, String title ) {
				if ((c.getText().length() == 0) || (c.getText().length() > 30)) {
					showMessage6(c, title + ". \nPlease enter no more than 30 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage6(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "City Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		// cmbProvince from CustomerGUI
			
			public static boolean isProvince(JTextComponent c, String title ) {
				if (c.getText().length() == 0) {
					showMessage7(c, title + " . \nPlease enter no more than 20 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage7(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "Province Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		// txtPostalCode from CustomerGUI

			public static boolean isPostalCode(JTextComponent c, String title ) {
				if (c.getText().length() != 6) {
					showMessage8(c, title + " . \n Please enter 6 char.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
			private static void showMessage8(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "PostalCode Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}
			
		// txtProductName from ProductGUI

			public static boolean isProductName(JTextComponent c, String title ) {
					if (c.getText().length() == 0) {
						showMessage9(c, title + " is a requared field. \nPlease enter no more than 30 char.");
						c.requestFocusInWindow();
						return false;
					}
					return true;
				}
			private static void showMessage9(JTextComponent c, String message) {
					JOptionPane.showMessageDialog(c, message, "Product Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
				}	
				
		// txtPrice from ProductGUI

			public static boolean isPrice(JTextComponent c, String title ) {
					if (c.getText().length() == 0) {
						showMessage10(c, title + " is a requared field. \nPlease re-enter.");
						c.requestFocusInWindow();
						return false;
					}
					return true;
					}
			private static void showMessage10(JTextComponent c, String message) {
					JOptionPane.showMessageDialog(c, message, "Product Price Invalid Entry", JOptionPane.ERROR_MESSAGE);
					}	
			
		// txtMIN from ProductGUI

			public static boolean isMin(JTextComponent cMin, String title ) {
				if (cMin.getText().length() == 0) {
					showMessage11(cMin, title + " is a requared field. \nPlease re-enter.");
					cMin.requestFocusInWindow();
					return false;
				}
				return true;
				}
			private static void showMessage11(JTextComponent cMin, String message) {
				JOptionPane.showMessageDialog(cMin, message, "Price Min invalid Entry", JOptionPane.ERROR_MESSAGE);
				}	
			
		// txtMAX from ProductGUI

			public static boolean isMax(JTextComponent cMax, String title ) {
				if (cMax.getText().length() == 0) {
					showMessage12(cMax, title + " is a requared field. \nPlease re-enter.");
					cMax.requestFocusInWindow();
					return false;
				}
				return true;
				}
			private static void showMessage12(JTextComponent cMax, String message) {
				JOptionPane.showMessageDialog(cMax, message, "Price Max invalid Entry", JOptionPane.ERROR_MESSAGE);
				}	
			
		// txtProductId from ProductGUI

			public static boolean isProductId(JTextComponent c, String title ) {
				if (c.getText().length() != 0) {
					showMessage13(c, title + " MUST be Empty. \nPlease clear it.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
				}
			private static void showMessage13(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "ProductID MUST BE EMPTY", JOptionPane.ERROR_MESSAGE);
				}	
			

			// txtProductId from ProductGUI UPLOAD

			public static boolean isNotProductId(JTextComponent c, String title ) {
				if (c.getText().length() == 0) {
					showMessage14(c, title + " is a requared field. \nPlease re-enter.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
				}
			private static void showMessage14(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "ProductID is invalid or empty", JOptionPane.ERROR_MESSAGE);
				}	
			
			
			// txtCustID from CustomerGUI Save

			public static boolean isCustID(JTextComponent c, String title ) {
				if (c.getText().length() != 0) {
					showMessage15(c, title + " Must be Empty. \nPlease clean it.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
				}
			private static void showMessage15(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "CustID must be empty", JOptionPane.ERROR_MESSAGE);
				}
		 
			
		// txtCustID from CustomerGUI First - if the record is 1 

			public static boolean isCustIDIsNull(JTextComponent c, String title ) {
				if (c.getText().length() == 0) {
					showMessage16(c, title + "\n Please insert data to the fields.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
				}
			private static void showMessage16(JTextComponent c, String message) {
				JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
				}

		// btnDisplay from CustomerGUI check Fist or Last Name has entered  

				public static boolean isFirstNameLastNameNull(JTextComponent c, JTextComponent b, String title ) {
					if ((c.getText().length() == 0) && (b.getText().length() == 0)) {
						showMessage17(c, title + " \n Please insert First or Last Name.");
						c.requestFocusInWindow();
						return false;
					}
					return true;
					}
				private static void showMessage17(JTextComponent c, String message) {
					JOptionPane.showMessageDialog(c, message, "First or Last Name is Empty", JOptionPane.ERROR_MESSAGE);
					}

				
		// btnFind from ProductGUI check 1,2, ( 3 and 4 has) entered  

				public static boolean isFind(JTextComponent a,JTextComponent b, JTextComponent c, JTextComponent d, String title ) {
					if ((a.getText().length() == 0) && (b.getText().length() == 0) && ((c.getText().length() == 0) || (d.getText().length() == 0))) {
						showMessage18(b, title + " \n Please insert Product ID OR Product Name OR Price rate .");
						c.requestFocusInWindow();
						return false;
					}
					return true;
					}
				private static void showMessage18(JTextComponent c, String message) {
					JOptionPane.showMessageDialog(c, message, "Product ID,  Prodact name, or Price rate is Empty", JOptionPane.ERROR_MESSAGE);
					}

		// btnFind from ProductGUI check Min and Max entered  

						public static boolean isFindMaxLessMin(JTextComponent b, JTextComponent c, String title ) {
							String min =b.getText();
							String max = c.getText();
							 if ((b.getText().length() != 0) && ((c.getText().length() != 0) && (Double.parseDouble(min) > Double.parseDouble(max)) )) {
								showMessage19(b, title + " \n Please, MAX PRICE must be more than MIN PRICE.");
								c.requestFocusInWindow();
								return false;
							}
							return true;
							}
						private static void showMessage19(JTextComponent c, String message) {
							JOptionPane.showMessageDialog(c, message, "Price rate is wrong", JOptionPane.ERROR_MESSAGE);
							}
			
		}

