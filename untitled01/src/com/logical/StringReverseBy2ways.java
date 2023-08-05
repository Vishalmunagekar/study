// 1. Using Customized logic
// 2. Using Standard JAVA API


package com.logical;

import java.util.Scanner;

public class StringReverseBy2ways {

	public static void main1(String[] args) {
		String original;
		String reverse = "";
		
		System.out.println("1. Enter String to reverse : ");
		
		Scanner sc = new Scanner(System.in);
		original = sc.nextLine();
		int len = original.length();
		for(int i = len - 1; i >= 0; i--)
		{
			reverse = reverse + original.charAt(i);
		}
		System.out.println("Original String : "+ original);
		System.out.println("Reverse String : "+ reverse);
	}
	
	//Using String.reverse() method
	public static void main(String[] args) {
		String original;
		String reverse = "";
		
		System.out.println("2. Enter String to reverse : ");
		
		Scanner sc = new Scanner(System.in);
		original = sc.nextLine();
		
		StringBuffer sb = new StringBuffer(original);
		reverse = sb.reverse().toString();
		
		System.out.println("Original String : "+ original);
		System.out.println("Reverse String : "+ reverse);
	}

}
