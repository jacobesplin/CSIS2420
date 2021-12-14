package com.finalProject;


/*
 * HashNode.java - Node class for use with the hash demo.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedHashing.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class HashNode
{
	HashNode next;
	int customerID;
	String variable;
	String[] data= new String[9];
	
	public HashNode(int customerID, String variable,String[] data)
	{
		this.customerID = customerID;
		this.variable = variable;
		this.data = data;
	}
}