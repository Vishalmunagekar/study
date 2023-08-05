package com.logical;

public class CangeCaseOfStrings {
	public static String firstUpper(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
	public static String firstLastUpper(String str) {
		int length = str.length();
		return str.substring(0,1).toUpperCase() +
			   str.substring(1, length - 2).toLowerCase() +
			   str.substring(length - 1, length).toUpperCase();
	}
	
	public static String camelCase(String str) {
		
		char[] ch = str.toLowerCase().toCharArray();
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i] == ' ')
			{
				ch[i+1] = Character.toUpperCase(ch[i+1]);
			}
		}
		
		StringBuffer sb = new StringBuffer(String.valueOf(ch));
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i)== ' ')
				sb.deleteCharAt(i);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "Hello, vIshaL munAgekar Is Hear How are you";
		String str1 = "vishalmunagekar";
		System.out.println("First Upper     : " +firstUpper(str1));
		System.out.println("FirstLast Upper : " + firstLastUpper(str1));
		System.out.println("camelCase       : " + camelCase(str));
	}
}
//Output :
//
//First Upper     : Vishalmunagekar
//FirstLast Upper : VishalmunagekR
//camelCase       : helloVishalMunagekarIsHearHowAreYou


