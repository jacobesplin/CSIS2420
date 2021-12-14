package com.finalProject;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JComboBox;
/*
 * Developed by Jacob Esplin
 * Code comes as is and has no warranty
 * Comments are limited on functions because of recommendations from "Clean Code" by Robert C. Martin. 
 * Function (methods) names should be describe what the function does and should be as short as possible. 
 */

public class GUI {

	private JFrame frame;
	private static JTextField textFieldFirstName;
	private static JTextField textFieldLastName;
	private static JTextField textFieldEmail;
	private JTable table;
	private static Hashing hashArrayFirstName= new Hashing(10);
	private static Hashing hashArrayLastName= new Hashing(10);
	private static Hashing hashArrayEmail= new Hashing(10);
	private static Hashing hashArrayArtist= new Hashing(10);
	private static Hashing hashArrayTitle= new Hashing(10);
	private MyTableModel tableModel = new MyTableModel(new String[] {"First Name","Last Name","Address","City","State","zip","Country","Phone","Email"});
	private ProductTableModel productTableModel = new ProductTableModel(new String[] {"Artist","Title","Released","Price","Media","Stock"});
	private static List<String>users = MySqlCon.getRecords();
	private static List<String>product = MySqlCon.getProducts();
	private OrdersForm orderForm;
	private OrderItems orderItems;
	private JLayeredPane customerSearch;
	private JLayeredPane addCustomer;
	private JLayeredPane Products;
	private JTextField textFieldAddFirstName;
	private JTextField textFieldAddLastName;
	private JTextField textFieldAddAddress;
	private JTextField textFieldAddCity;
	private JTextField textFieldAddState;
	private JTextField textFieldAddZip;
	private JTextField textFieldAddEmail;
	private JTextField textFieldAddPhone;
	private JComboBox comboBoxCountry;
	private JTable productTable;
	private JTextField textFieldArtist;
	private JTextField textFieldTitle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1188, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		customerSearch = new JLayeredPane();
		frame.getContentPane().add(customerSearch, "name_516162344328300");
		customerSearch.setLayout(null);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(89, 70, 147, 20);
		customerSearch.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 57, 77, 46);
		customerSearch.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(246, 57, 77, 46);
		customerSearch.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(325, 70, 147, 20);
		customerSearch.add(textFieldLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(500, 57, 77, 46);
		customerSearch.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(579, 70, 147, 20);
		customerSearch.add(textFieldEmail);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSearchResults();
				
			}
		});
		btnSearch.setBounds(735, 69, 89, 23);
		customerSearch.add(btnSearch);
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 137, 1126, 173);
		customerSearch.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Results");
		lblNewLabel_1.setBounds(10, 97, 77, 31);
		customerSearch.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer Lookup");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 11, 980, 31);
		customerSearch.add(lblNewLabel_1_1);
		
		JButton btnPlaceOrder = new JButton("Start Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startOrder();
			}
		});
		btnPlaceOrder.setBounds(1051, 11, 111, 23);
		customerSearch.add(btnPlaceOrder);
		
		addCustomer = new JLayeredPane();
		frame.getContentPane().add(addCustomer, "name_516175780964000");
		
		JLabel lblNewLabel_2 = new JLabel("Add Customer");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(10, 0, 990, 52);
		addCustomer.add(lblNewLabel_2);
		
		textFieldAddFirstName = new JTextField();
		textFieldAddFirstName.setBounds(385, 63, 201, 20);
		addCustomer.add(textFieldAddFirstName);
		textFieldAddFirstName.setColumns(10);
		
		textFieldAddLastName = new JTextField();
		textFieldAddLastName.setColumns(10);
		textFieldAddLastName.setBounds(385, 100, 201, 20);
		addCustomer.add(textFieldAddLastName);
		
		textFieldAddAddress = new JTextField();
		textFieldAddAddress.setColumns(10);
		textFieldAddAddress.setBounds(385, 135, 201, 20);
		addCustomer.add(textFieldAddAddress);
		
		textFieldAddCity = new JTextField();
		textFieldAddCity.setColumns(10);
		textFieldAddCity.setBounds(385, 170, 86, 20);
		addCustomer.add(textFieldAddCity);
		
		textFieldAddState = new JTextField();
		textFieldAddState.setColumns(10);
		textFieldAddState.setBounds(481, 170, 38, 20);
		addCustomer.add(textFieldAddState);
		
		textFieldAddZip = new JTextField();
		textFieldAddZip.setColumns(10);
		textFieldAddZip.setBounds(525, 170, 62, 20);
		addCustomer.add(textFieldAddZip);
		
		textFieldAddEmail = new JTextField();
		textFieldAddEmail.setColumns(10);
		textFieldAddEmail.setBounds(385, 216, 201, 20);
		addCustomer.add(textFieldAddEmail);
		
		textFieldAddPhone = new JTextField();
		textFieldAddPhone.setColumns(10);
		textFieldAddPhone.setBounds(385, 247, 201, 20);
		addCustomer.add(textFieldAddPhone);
		
		comboBoxCountry = new JComboBox(new String[] {"US","CA"});
		comboBoxCountry.setBounds(500, 191, 86, 22);
		addCustomer.add(comboBoxCountry);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setBounds(385, 44, 68, 14);
		addCustomer.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Last Name");
		lblNewLabel_3_1.setBounds(385, 85, 68, 14);
		addCustomer.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Address");
		lblNewLabel_3_2.setBounds(385, 120, 68, 14);
		addCustomer.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("City");
		lblNewLabel_3_3.setBounds(385, 155, 68, 14);
		addCustomer.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("State");
		lblNewLabel_3_4.setBounds(481, 155, 68, 14);
		addCustomer.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Zip");
		lblNewLabel_3_5.setBounds(530, 155, 68, 14);
		addCustomer.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Email");
		lblNewLabel_3_6.setBounds(385, 191, 68, 22);
		addCustomer.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Phone");
		lblNewLabel_3_7.setBounds(385, 235, 68, 14);
		addCustomer.add(lblNewLabel_3_7);
		
		JButton btnAddNewCustomerSubmit = new JButton("Submit");
		btnAddNewCustomerSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCustomer();
			}
		});
		btnAddNewCustomerSubmit.setBounds(385, 274, 201, 23);
		addCustomer.add(btnAddNewCustomerSubmit);
		
		Products = new JLayeredPane();
		frame.getContentPane().add(Products, "name_522588108359000");
		productTable = new JTable(productTableModel);
		productTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		productTable.setFillsViewportHeight(true);

		JScrollPane scrollPane_1 = new JScrollPane(productTable);
		scrollPane_1.setBounds(25, 106, 1126, 173);
		Products.add(scrollPane_1);
		
		textFieldArtist = new JTextField();
		textFieldArtist.setBounds(122, 11, 176, 20);
		Products.add(textFieldArtist);
		textFieldArtist.setColumns(10);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(122, 36, 176, 20);
		Products.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JButton btnSearchProducts = new JButton("Search");
		btnSearchProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchProducts();
			}
		});
		btnSearchProducts.setBounds(119, 67, 89, 23);
		Products.add(btnSearchProducts);
		
		JLabel lblNewLabel_4 = new JLabel("Artist");
		lblNewLabel_4.setBounds(37, 11, 75, 20);
		Products.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Title");
		lblNewLabel_4_1.setBounds(37, 36, 75, 20);
		Products.add(lblNewLabel_4_1);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				placeOrder();
			}
		});
		btnOrder.setBounds(1062, 72, 89, 23);
		Products.add(btnOrder);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCustomerMenu = new JMenu("Customers");
		menuBar.add(mnCustomerMenu);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSearch();
				
			}
		});
		mnCustomerMenu.add(mntmSearch);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAddCustomer();
				
			}
		});
		mnCustomerMenu.add(mntmAdd);
		
		JMenuItem mntmOrder = new JMenuItem("Order");
		mntmOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showProductOrdering();
				
			}
		});
		mnCustomerMenu.add(mntmOrder);
		loadData();
		loadProductData();
	}
	private void showProductOrdering() {
		addCustomer.setVisible(false);
		customerSearch.setVisible(false);
		Products.setVisible(true);
	}
	private void showSearch() {
		addCustomer.setVisible(false);
		customerSearch.setVisible(true);
		Products.setVisible(false);
	}
	private void showAddCustomer() {
		addCustomer.setVisible(true);
		customerSearch.setVisible(false);
		Products.setVisible(false);
	}
	/*
	private void print(Object obj) {
		System.out.println(obj);
	}
	*/
	/*
	 * Customer search results table 
	 */
	private void setUpTable(Object[][] data) {
		tableModel.setDataValues(data);
		int rowCount = tableModel.getRowCount();
		int columnCount =tableModel.getColumnCount();
		for(int i=0;i<rowCount;i++) {
			//System.out.println(data[i][0]);
			for(int j=0;j<columnCount;j++) {
				//System.out.println(data[i][j]);
				tableModel.refresh(i, j);
			}
		}
		
	}
	
	private static void addDataToHashArray(String[] values,String[] dataValues) {
		hashArrayFirstName.appendNode(hashArrayFirstName.hashIt(values[1]), Integer.valueOf(values[0]), values[1],dataValues);
		hashArrayLastName.appendNode(hashArrayLastName.hashIt(values[2]), Integer.valueOf(values[0]), values[2],dataValues);
		hashArrayEmail.appendNode(hashArrayEmail.hashIt(values[9]), Integer.valueOf(values[0]), values[9],dataValues);
	}
	private void addCustomer() {
		String values =String.valueOf(Integer.valueOf(users.get(users.size()-1).split(",")[0])+1)+","+makeFirstCharCapital(textFieldAddFirstName.getText())+","+makeFirstCharCapital(textFieldAddLastName.getText())+","+textFieldAddAddress.getText()+","+textFieldAddCity.getText()+","+textFieldAddState.getText()+","+textFieldAddZip.getText()+","+comboBoxCountry.getSelectedItem().toString()+","+textFieldAddPhone.getText()+","+textFieldAddEmail.getText();
		users.add(values);
		loadData();
		NewCustomerForm form = new NewCustomerForm(values.split(","));
		if(MySqlCon.commitCustomerToDatabase(form)) {
			JOptionPane.showMessageDialog(null,"Customer has been added","Customer Service",1);
		}
		else {
			JOptionPane.showMessageDialog(null,"There was an issue adding customer. Please try again.","Customer Service",1);
		}
	}

	private static void loadData() {
		for (int j = 0; j < users.size(); j++)
		{
			String[] values =  users.get(j).split(",");
			String[] dataValues = {values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9]};
			addDataToHashArray(values,dataValues);
		}
		
	}
	private String makeFirstCharCapital(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
	}
	private HashNode searchResults() {
		HashNode results = null;
		String firstName = textFieldFirstName.getText();
		String lastName = textFieldLastName.getText();
		String email = textFieldEmail.getText();
		if(firstName.length()>0 && lastName.length() == 0 && email.length()==0) {
			results = hashArrayFirstName.search(makeFirstCharCapital(firstName));
		}
		if(lastName.length()>0)results = hashArrayLastName.search(makeFirstCharCapital(lastName));
		if(email.length()>0)results = hashArrayEmail.search(makeFirstCharCapital(email));
		return results;
	}
	private void showSearchResults() {
		HashNode results = searchResults();
		if(results!=null) {
			String[] values = results.data;
			Object[][] data = {
				{values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]}};
			setUpTable(data);
		}else {
			Object[][] data = new Object[users.size()][9];
			for(int i =0; i <users.size();i++) {
				String[] values = users.get(i).split(",");
				String[] dataValues = {values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9]};
				data[i]= dataValues;
				setUpTable(data);
			}
		}
	}
	private static void addProductDataToHashArray(String[] values,String[] dataValues) {
		hashArrayArtist.appendNode(hashArrayArtist.hashIt(values[1]), Integer.valueOf(values[0]), values[1],dataValues);
		hashArrayTitle.appendNode(hashArrayTitle.hashIt(values[2]), Integer.valueOf(values[0]), values[2],dataValues);
	}
	private static void loadProductData() {
		for (int j = 0; j < product.size(); j++)
		{
			String[] values =  product.get(j).split(",");
			String[] dataValues = {values[1],values[2],values[3],values[4],values[5],values[6]};
			addProductDataToHashArray(values,dataValues);
		}
		
	}
	private HashNode searchResultsProducts() {
		HashNode results = null;
		String artist = textFieldArtist.getText();
		String title = textFieldTitle.getText();
		if(artist.length()>0) {
			results = hashArrayArtist.searchProducts(artist);
		}
		if(title.length()>0)results = hashArrayTitle.searchProducts(title);
		
		return results;
	}
	private void setUpProductTable(Object[][] data) {
		productTableModel.setDataValues(data);
		int rowCount = productTableModel.getRowCount();
		int columnCount =productTableModel.getColumnCount();
		for(int i=0;i<rowCount;i++) {
			//System.out.println(data[i][0]);
			for(int j=0;j<columnCount;j++) {
				//System.out.println(data[i][j]);
				productTableModel.refresh(i, j);
			}
		}
		
	}
	private void searchProducts() {
		HashNode results = searchResultsProducts();
		if(results!=null) {
			String[] values = results.data;
			//print(values[0]);
			Object[][] data = {
				{values[0],values[1],values[2],values[3],values[4],values[5]}};
			setUpProductTable(data);
		}else {
			Object[][] data = new Object[product.size()][7];
			for(int i =0; i <product.size();i++) {
				String[] values = product.get(i).split(",");
				String[] dataValues = {values[1],values[2],values[3],values[4],values[5],values[6]};
				data[i]= dataValues;
				setUpProductTable(data);
			}
		}
	}
	private String date() {
		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
	    System.out.println(date);
	    return date;  
	}
	private HashNode searchForCustomerID(String firstName) {
		HashNode results = null;
		results = hashArrayFirstName.search(makeFirstCharCapital(firstName));
		return results;
	}
	private HashNode searchForProductID(String artist) {
		HashNode results = null;
		//print(artist);
		results = hashArrayArtist.searchProducts(artist);
		return results;
	}
	private void startOrder() {
		int tableRow = table.getSelectedRow();
		orderForm = new OrdersForm(customerID(table.getValueAt(tableRow,0)),date());
		showProductOrdering();
	}
	private int customerID(Object firstName) {	
		return searchForCustomerID((String)firstName).customerID;
	}
	private int productID(String artist) {	
		return searchForProductID(artist).customerID;
	}
	private void placeOrder() {
		int tableRow = productTable.getSelectedRow();
		String[] order = new String[6];
		for(int i = 0; i<5;i++) {
			order[i] = (String)productTable.getValueAt(tableRow,i);
		}
		orderItems = new OrderItems(productID(order[0]),Double.valueOf(order[3]));
		
		if(MySqlCon.orderForCustomer(orderForm,orderItems)) {
			JOptionPane.showMessageDialog(null,"Customer order has been placed","Customer Service",1);
		}
		else {
			JOptionPane.showMessageDialog(null,"There was an issue ordering. Please try again.","Customer Service",1);
		}
		
	}
}
