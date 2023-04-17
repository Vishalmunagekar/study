package com.logical;

public class StringPalindrom {

	public static boolean isPalindrom(String str) {
		int l = str.length();
		int i = 0, j = l-1;
		
		while(i < j)
		{
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void main(String[] args) {
		String str = "12321"; // time complexity = o(n/2)
		System.out.println(isPalindrom(str));
	}
}
