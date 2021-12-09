package com.a2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainIP {
	static BinarySearchTree bstIP = new BinarySearchTree();
	static BinarySearchTree bstName = new BinarySearchTree();
	static List<String> users = loadCSV();
	private static List<String> loadCSV(){
		List<String> contents = new ArrayList<String>();
		 try {
		      File myObj = new File("users.csv");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        contents.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		return contents;
	}
	private static void print(Object obj) {
		System.out.println(obj);
	}
	private static String findByIpAddress(int ip, List<String> users) {
		BSTNode searchResults  = bstIP.search(bstIP.root,ip);
		if(searchResults != null)return "Found: 10.0.0."+String.valueOf(searchResults.data)+ " "+searchResults.name;
		return "IP 10.0.0."+String.valueOf(ip)+" not found";
	}
	private static int getNameLocation(List<String> user,String name) {
		for(int i = 0;i<user.size();i++) {
			String nameTemp = user.get(i).split(",")[1];
			//print(nameTemp);
			if(nameTemp.equalsIgnoreCase(name)) {
				
				return i;
			}
		}
		return -1;
	}
	private static String findByName(String username, List<String> users) {
		int results = getNameLocation(users, username);
		if( results!=-1) {
			BSTNode searchResults  = bstName.searchName(bstName.root,results);
			if(searchResults != null)return "Found: 10.0.0."+String.valueOf(searchResults.name)+ " "+users.get(searchResults.data).split(",")[1];
		}
		return "User "+username+" not found";
	}
	private static void listOfCommands() {
		print( "-------------------------\r\n"
				+ "1 Build Users Tree\r\n"
				+ "2 Find by IP Address\r\n"
				+ "3 Find by Username\r\n"
				+ "4 Report Number of Nodes\r\n"
				+ "5 Print Entire Tree\r\n"
				+ "6 Exit\r\n"
				+ "-------------------------\r\n"
				+ "Enter 1, 2, 3, 4, 5 or 6:");
	}
	private static void buildTree() {
		for(int i =0;i<users.size();i++) {
			int ip = Integer.valueOf(users.get(i).split(",")[0]);
			//print(users.get(i).split(",")[0]);
			bstIP.insert(ip,users.get(i).split(",")[1]);
			bstName.insert(i,users.get(i).split(",")[0]);
			//print(i);   
			
		}
	}
	public static void main(String[] args) {
		listOfCommands();
		do {
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    String cmd = myObj.nextLine();  // Read user input
		    if(cmd.equalsIgnoreCase("1")) {
		    	print("Tree Built");
		    	buildTree();
		    }else if(cmd.equalsIgnoreCase("2")) {
		    	myObj = new Scanner(System.in); 
		    	System.out.println("Find by IP Address");
		    	int ip = Integer.valueOf(myObj.nextLine());  // Read user input	
		    	print(findByIpAddress(ip,users));
		    }
		    else if(cmd.equalsIgnoreCase("3")) {
		    	myObj = new Scanner(System.in); 
		    	print("Find by Username?");
		    	String name = myObj.nextLine();  // Read user input	
		    	print(findByName(name,users));
		    }
		    else if(cmd.equalsIgnoreCase("4")) {
		    	print("Total number of nodes");
		    	print(bstIP.depth(bstIP.root));
		    	print(bstName.depth(bstName.root));
		    }else if(cmd.equalsIgnoreCase("5")) {
		    	print("Print Entire Tree");
		    	bstName.inOrderTraverse(bstName.root);
		    	bstIP.inOrderTraverse(bstIP.root);
		    }
		    else if(cmd.equalsIgnoreCase("6")) {
		    	print("goodbye!");
		    	break;
		    }
		}while(true);
		
	}

}
