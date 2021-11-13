package com.week9_10_assignment1;
/*
 * BinarySearchTree.java - Class to manage binary search 
 *                         tree implementations.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 */

public class BinarySearchTree 
{
	public BSTNode root;
	int minValue(BSTNode root)
	{
		int minv = root.data;
		while (root.left != null)
		{
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}
	public BSTNode delete(BSTNode myRoot, int value) {
		if(myRoot == null)return myRoot;
		/* Otherwise, recur down the tree */
		if (value < myRoot.data)
			myRoot.left = delete(myRoot.left, value);
		else if (value > myRoot.data)
			myRoot.right = delete(myRoot.right, value);
		else {
			if (myRoot.left == null)
				return myRoot.right;
			else if (myRoot.right == null)
				return myRoot.left;
			myRoot.data = minValue(myRoot.right);
			myRoot.right = delete(myRoot.right, myRoot.data);
		}
		return myRoot;
		
	}
	private int counterLeft(BSTNode myRoot,int counter) {
		if(myRoot.left!= null)return counterLeft(myRoot.left,counter+1);
		return counter;
	}
	private int counterRight(BSTNode myRoot,int counter) {
		if(myRoot.right !=null)return counterRight(myRoot.right,counter+1);
		return counter;
	}
	
	public int depth(BSTNode myRoot) {
		if(myRoot == null)return 0;  
		else
		{  
			int counterLeft = counterLeft(myRoot,1);  
			int counterRight = counterRight(myRoot,1);
			if(counterLeft>counterRight)return counterLeft;
			if(counterRight>counterLeft)return counterRight;
		} 
		return 0;
	}
	
	public BSTNode search(BSTNode root, int searchValue) {
		if (root == null || root.data == searchValue)return root;
		if (root.data < searchValue)return search(root.right, searchValue);
		return search(root.left, searchValue);
	}

	public void insert(int data)
	{
		BSTNode newNode = new BSTNode(data);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			BSTNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(data < current.data)
				{  
					current = current.left;  
					if(current == null)
					{  
						parent.left = newNode;  
						return;  
					}  
				}  
				else
				{  
					current = current.right;  
					if(current == null)
					{  
						parent.right = newNode;  
						return;  
					}  
				}  
			}  
		}  
	}

	public void preOrderTraverse(BSTNode n)
	{  

        
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			System.out.print(n.data + " ");  
			if(n.left!= null)
			{
				preOrderTraverse(n.left);  
			}
			if(n.right!= null)
			{
				preOrderTraverse(n.right);  
			}
		}

	}  

	public void inOrderTraverse(BSTNode n)
	{  
		
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				inOrderTraverse(n.left);  
			}
			System.out.print(n.data + " ");  
			if(n.right!= null)
			{
				inOrderTraverse(n.right);  
			}
		}  

	}  

	public void postOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				postOrderTraverse(n.left);  
			}
			if(n.right!= null)
			{
				postOrderTraverse(n.right);  
			}
			System.out.print(n.data + " ");  
		}
	}  

}
