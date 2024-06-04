package com.logical;

import java.util.stream.IntStream;

public class StringReverseWithoutExtraSpace {
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
//		System.out.println(StringRevers(str.toCharArray()));
		reversString(str);
		
	}

	public static void reversString(String str){
		int i = str.length() -1;
		while (i >= 0){
			System.out.print(str.charAt(i));
			i--;
		}
	}
}
