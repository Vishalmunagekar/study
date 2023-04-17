package com.logical;

public class Palindrom {

	public static void main(String[] args) {
		String str1 = "123321";
		boolean flag = true;
		StringBuilder sb= new StringBuilder(str1).reverse();
		String str2 = sb.toString();
		
		for(int i = 0; i < str1.length(); i ++)
		{
			if(str1.charAt(i) != str2.charAt(i)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);
	}
}
