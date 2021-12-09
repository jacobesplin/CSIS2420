package com.a2;
/*
 * BSTNode.java - Binary Search Tree node class.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 */

public class BSTNode 
{

	int data;
	String name;

	BSTNode left;
	BSTNode right;

	public BSTNode(int data,String name) 
	{
		this.name = name;
		this.data = data;
	}
	
}
