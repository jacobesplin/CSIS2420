package com.finalProject;


/*
 * HashingDemo1t.java - Class to demonstrate hash tables.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedHashing.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class Hashing
{

	private  HashNode[] hashArray;
	HashNode head;
	
	public Hashing(int value) {
		hashArray= new HashNode[value];
	}
	
	public int hashIt(String data)
	{
		int asciiTotal = 0;
		for (int n = 0; n < data.length(); n++)
		{
			char c = data.charAt(n);
			asciiTotal = asciiTotal + (int)c;
		}
		return asciiTotal % hashArray.length;
	}
	
	public void appendNode(int arrayIndex, int customerID, String name,String[] data)
	{
		if (hashArray[arrayIndex] == null)
		{
			hashArray[arrayIndex] = new HashNode(customerID, name, data);
		}
		else
		{
			HashNode current = hashArray[arrayIndex];
			while (current.next != null)
			{
				current = current.next;
			}
			current.next = new HashNode(customerID, name,data);
		}
	}
	
	public HashNode search(String searchValue) {
		long start = System.nanoTime();
		HashNode current = hashArray[hashIt(searchValue)];
		if(current.variable.equalsIgnoreCase(searchValue)) {
			long end = System.nanoTime();
            long duration = end - start;
            System.out.println("Finished Searching");
            System.out.println(duration);
			return current;
		}
		while(current.next!=null) {
			current = current.next;
			if(current.variable.equalsIgnoreCase(searchValue)) {
				long end = System.nanoTime();
	            long duration = end - start;
	            System.out.println("Finished Searching");
	            System.out.println(duration);
				return current;
			}
			//current = current.next;
		}
		long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Finished Searching");
        System.out.println(duration);
		return null;
	  }
	public HashNode searchProducts(String searchValue) {
		long start = System.nanoTime();
		System.out.println(searchValue);
		HashNode current = hashArray[hashIt(searchValue)];
		if(current.variable.contains(searchValue)) {
			long end = System.nanoTime();
            long duration = end - start;
            System.out.println("Finished Searching Products");
            System.out.println(duration);
			return current;
		}
		while(current.next!=null) {
			current = current.next;
			if(current.variable.contains(searchValue)) {
				long end = System.nanoTime();
	            long duration = end - start;
	            System.out.println("Finished Searching Products");
	            System.out.println(duration);
				return current;
			}
			//current = current.next;
		}
		
		long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Finished Searching Products");
        System.out.println(duration);
		return null;
	  }
}

