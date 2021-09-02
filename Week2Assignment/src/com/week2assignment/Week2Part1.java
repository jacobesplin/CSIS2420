package com.week2assignment;

import java.util.Scanner;

public class Week2Part1 {
	
	/*
	private static boolean checkIfInt(String str) {
		if(str.matches("-?(0|[1-9]\\d*)"))return true;
		return false;
	}
	*/
	public static void print(Object obj) {
		System.out.println(obj);
	}
	private static void printf(String format,Object arguments) {
		System.out.printf(format, arguments);
	}
	
	public static int sumLoop(int min, int max) {
		int sum = 0;
		for(int i = min; i<max; i++) {
			sum+=i;
		}
		return sum;
	}
	private static String formatTotal(int total) {
		String totalStr = String.valueOf(total);
		//print(totalStr);
		String builder = "";
		String newBuilder = "";
		int counter = 0;
		int increment = 0;
		//print(totalStr.charAt(totalStr.length()-1));
		if(totalStr.length()>3) {
			for(int i = totalStr.length()-1; i !=-1 ; i--) {
				//print(totalStr.charAt(i));
				builder += totalStr.charAt(i);
				if(counter == 2+increment) {
					builder+=",";
					increment+=3;
				}
				//print(i);
				counter+=1;
			}
			
			for(int j = builder.length()-1; j!=-1;j--)newBuilder += builder.charAt(j);
		}
		else {
			return totalStr;
		}
		
		if(newBuilder.substring(0,1).equals(","))newBuilder = newBuilder.substring(1,newBuilder.length());
		if(newBuilder.substring(0,1).equals("-") && newBuilder.substring(1,2).equals(",") )newBuilder ="-"+ newBuilder.substring(2,newBuilder.length());
		return newBuilder;
	}
	private static void gameScoreHeader() {
		print("------------------");
		print("Total Scores");
		print("------------------");
	}
	private static void printGameScoreRow(int row,int value) {
		printf("%s%n","Row "+String.valueOf(row)+":"+String.valueOf(value));
	}
	private static void gameScoreFooter(int highScoreRow) {
		print("-----------------");
		print("High Score: Row "+String.valueOf(highScoreRow));
		print("-----------------");
	}
	private static void evaluateGameScores(int[][] gameScores) {
		int sum = 0;
		int highScore = 0;
		int highScoreRow = 0;
		gameScoreHeader();
		for(int i = 0; i < gameScores.length; i ++) {
			for(int j = 0; j<gameScores[i].length; j++) {
				sum+=gameScores[i][j];
				if(gameScores[i][j]>highScore) {
					highScore = gameScores[i][j];
					highScoreRow = i+1;
				}
			}
			printGameScoreRow(i+1,sum);
			sum = 0;
			
		}
		gameScoreFooter(highScoreRow);
		
	}
	public static void main(String[] args) 
	{
		int min,max;
		int total = 0;
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    printf("%s %n","Enter a min value");
	    min =  myObj.nextInt();
	    printf("%s %n","Enter a max value");
	    //myObj = new Scanner(System.in);
	    max =  myObj.nextInt();
	    myObj.close();
	    total = sumLoop(min,max);
	    printf("%s%n",formatTotal(total));
	    printf("%n%n","");
	    //printf("%s%n","_______________");
	    int[][] gameScores ={
	    		{44,63,45,23,76,45},
	    		{76,23,56,98,33,24},
	    		{23,71,92,39,45,44},
	    		{70,20,46,64,77,29},
	    		{83,45,99,20,10,21},
	    		{86,34,92,34,88,11}
	    		};
	    evaluateGameScores(gameScores);
	    

	    
	    
	    
	}

}
