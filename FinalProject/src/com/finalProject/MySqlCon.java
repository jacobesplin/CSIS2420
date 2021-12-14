package com.finalProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * I have replaced the mysql connection with that of loading in a csv file with all the data inside the mysql database. If you have a database to connect to please 
 * uncomment and put in your username/password to set up a connection 
 */

public class MySqlCon {
	private static List<String> loadFiles(String fileLoc){
		List<String>dataArray= new ArrayList<String>();
		try {
		      File myObj = new File(fileLoc);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        dataArray.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return dataArray;
	}
	private static void saveData(String fileLoc,String data) {
		try {
		      FileWriter myWriter = new FileWriter(fileLoc, true);
		      myWriter.write(data);
		      myWriter.close();
		      //System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      //System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	/*
	private static Connection connectToDataBase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost/record_store","username","password"); 
		return con;
	}
	*/
	public static List<String>getRecords(){
		long start = System.nanoTime();
		List<String> customerRecords = loadFiles("./customerData.csv");
		long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Time to get data from database");
        System.out.println(duration);
		/*
		try{  
			
			List<String> customerRecords = new ArrayList<String>();
			Statement stmt=(Statement) connectToDataBase().createStatement();  
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from customers"); 
			while(rs.next()) { 
				customerRecords.add(String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getString(10));  
				//saveData("./customerData.csv",String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getString(10)+"\n");
			}
			connectToDataBase().close(); 
			long end = System.nanoTime();
            long duration = end - start;
            System.out.println("Time to get data from database");
            System.out.println(duration);
			return customerRecords;
			 
		}
		catch(Exception e){ 
			System.out.println(e);
		} 
		*/
		return customerRecords;
	}
	public static List<String>getProducts(){
		long start = System.nanoTime();
		List<String> products = loadFiles("./products.csv");
		long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Time to get data from database");
        System.out.println(duration);
		/*
		try{  
			List<String> products = new ArrayList<String>();
			 
			Statement stmt=(Statement) connectToDataBase().createStatement();  
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from products"); 
			while(rs.next()) { 
				products.add(String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+rs.getString(3)+","+String.valueOf(rs.getInt(4))+","+String.valueOf(rs.getDouble(5))+","+rs.getString(6)+","+String.valueOf(rs.getString(7)));  
				//saveData("./prodcuts.csv",String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+rs.getString(3)+","+String.valueOf(rs.getInt(4))+","+String.valueOf(rs.getDouble(5))+","+rs.getString(6)+","+String.valueOf(rs.getString(7))+"\n");
			}
			connectToDataBase().close(); 
			long end = System.nanoTime();
            long duration = end - start;
            System.out.println("Time to get data from database");
            System.out.println(duration);
			return products;
			 
		}
		catch(Exception e){ 
			System.out.println(e);
		} 
		*/
		return products;
	}
	public static boolean commitCustomerToDatabase(NewCustomerForm form) {
		long start = System.nanoTime();
		saveData("./customerData.csv",String.valueOf(form.id)+","+form.firstName+","+form.lastName+","+form.address+","+form.city+","+form.state+","+form.zip+","+form.country+","+form.phone+","+form.email+"\n");
		long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Time to add user to database");
        System.out.println(duration);
        /*
		try {
			java.sql.Statement stmt=connectToDataBase().createStatement();  
			String sql = "INSERT INTO `customers` (`customer_id`,`first_name`,`last_name`,`address1`,`city`,`state`,`zip`,`country`,`phone`,`email`) VALUES"
					+ " ("+form.id+",'"+form.firstName+"','"+form.lastName+"','"+form.address+"','"+form.city+"','"+form.state+"','"+form.zip+"','"+form.country+"','"+form.phone+"','"+form.email+"')";
	        stmt.executeUpdate(sql);
	        connectToDataBase().close();
	        long end = System.nanoTime();
            long duration = end - start;
	        System.out.println("Time to add user to database");
            System.out.println(duration);
	        return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		*/
		return true;
	}
	public static boolean orderForCustomer(OrdersForm orderForm,OrderItems itemsForm) {
		long start = System.nanoTime();
		saveData("./customerOrder.csv",orderForm.customerId+","+orderForm.orderDate+","+orderForm.shipmentStatus+","+itemsForm.productId+","+itemsForm.price+"\n");
		long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Time to add user to database");
        System.out.println(duration);
        /*
		try {
			java.sql.Statement stmt=connectToDataBase().createStatement();  
			String sql = "INSERT INTO `orders` (`customer_id`,`order_date`,`order_status`,`shipped`,`delivered`) VALUES"
					+ " ('"+orderForm.customerId+"','"+orderForm.orderDate+"',14,null,null)";
	        stmt.executeUpdate(sql);
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from orders"); 
			int order_id=0;
			while(rs.next()) { 
				order_id = rs.getInt(1);  
				
			}
			sql = "INSERT INTO `order_items` (`order_id`,`product_id`,`price`) VALUES"
					+ " ('"+order_id+"','"+itemsForm.productId+"',"+itemsForm.price+")";
	        stmt.executeUpdate(sql);
			connectToDataBase().close(); 
	        long end = System.nanoTime();
            long duration = end - start;
	        System.out.println("Time to add user to database");
            System.out.println(duration);
	        return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		*/
		return true;
	}
	/*
	public static void main(String args[]){  
		//getRecords();
		getProducts();
	} 
	*/
	
}
