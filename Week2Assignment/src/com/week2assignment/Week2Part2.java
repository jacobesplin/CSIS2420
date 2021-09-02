package com.week2assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Week2Part2 {
	
	private static void printf(String format,Object arguments) {
		System.out.printf(format, arguments);
	}
	private static double average(double sum,int rowCount) {
		return sum/rowCount;
	}
	private static String num2str(Object obj) {
		return String.valueOf(obj);
	}
	private static float str2float(String num) {
		return Float.parseFloat(num);
	}
	public static void main(String[] args) throws IOException {
		float sum = 0;
		int rowCounter = 0;
		File file = new File("Week2Part2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));  
		String readRow;
		while ((readRow = br.readLine()) != null) {
		   sum+=str2float(readRow);
		   rowCounter+=1;
		}
		br.close();
		printf("%s%n","File Week2Part2.txt was loaded. The number of rows "+num2str(rowCounter)+". The sum of the numbers "+num2str(sum)+". The average is "+num2str(average(sum,rowCounter)+"."));
	}
}
