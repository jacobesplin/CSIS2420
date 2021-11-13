package com.week9_10_assignment1;
/*
 * BSTDemo.java - Class to demonstrate a binary search tree.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 **/

import java.util.Random;

public class BSTDemo 
{
	private static void PRE(BinarySearchTree bst) {
		System.out.print("PreOrder Traverse:\t");
		long start = System.nanoTime();
		bst.preOrderTraverse(bst.root);
		long end = System.nanoTime();
        long duration = end - start;
        System.out.printf("Duration: %,d nanoseconds %n", duration);
	}
	private static void IOT(BinarySearchTree bst) {
		long start = System.nanoTime();
		System.out.print("InOrder Traverse:\t");
		bst.inOrderTraverse(bst.root);
		long end = System.nanoTime();
        long duration = end - start;
        System.out.printf("Duration: %,d nanoseconds %n", duration);
	}
	private static void POST(BinarySearchTree bst) {
		long start = System.nanoTime();
		System.out.print("PostOrder Traverse:\t");
		bst.postOrderTraverse(bst.root);
		long end = System.nanoTime();
        long duration = end - start;
        System.out.printf("Duration: %,d nanoseconds %n", duration);
	}
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		// Sample Data: 20, 33, 18, 19, 46, 29, 4, 62
		int min = 0;
        int max = 1000000;
        int[] numIters = {10,100,1_000,10_000,100_000,1_000_000,10_000_000};
        Random rand = new Random();
        for(int i=0;i<numIters.length;i++) {
        	for(int k=0;k<numIters[i];k++) {
        		bst.insert(rand.nextInt((max - min) + 1) + min);     
        	}
        	System.out.println(i);
        	PRE(bst);
			System.out.println();
			IOT(bst);
			System.out.println();
			POST(bst);
			bst = new BinarySearchTree();
			
			/*
			BSTNode searchResults  = bst.search(bst.root,4);
			System.out.println();
			System.out.println(searchResults.data);
			System.out.println(bst.depth(bst.root));
			searchResults  = bst.delete(bst.root,20);
			bst.preOrderTraverse(searchResults);
			//System.out.println(searchResults.right.data);
			 
			 */
        }
		
	}
}
