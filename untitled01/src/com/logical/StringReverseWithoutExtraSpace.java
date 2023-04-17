package com.logical;

public class Main {
	public static String StringRevers(char[] str)
	{
		char ch;
		int start = 0;
		int end = str.length - 1;
		while(start < end) {
			ch = str[end];
			str[end] = str[start];
			str[start] = ch;
			start++;
			end--;
		}
		return String.valueOf(str);
	}

	public static void main(String[] args) {
		//reverse string without using extra space
		String str = "ABCDEFGHIJKLMN";
		System.out.println(StringRevers(str.toCharArray()));
		
	}
}
