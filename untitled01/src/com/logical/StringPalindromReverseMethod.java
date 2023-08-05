package com.logical;

public class StringPalindromReverseMethod {

	public static void main(String[] args) {
		String str1 = "123321";
		
		boolean flag = true;
		
		StringBuilder sb= new StringBuilder(str1).reverse();
		String str2 = sb.toString();
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		
		//System.out.println(str1);
		//System.out.println(str2);
		
		for(int i = 0; i < str1.length(); i ++)
		{
			if(char1[i] != char2[i]) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);
	}
}
