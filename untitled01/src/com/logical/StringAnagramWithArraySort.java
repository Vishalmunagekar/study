package com.logical;

import java.util.Arrays;

public class StringAnagram {

	public static boolean isAnagram(String str1, String str2)
	{
		int length1 = str1.length();
		int length2 = str2.length();
		if(length1 != length2)
			return false;

		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();

		Arrays.sort(char1);
		Arrays.sort(char2);

		for(int i =0; i < length1; i++)
			if(char1[i] != char2[i])
				return false;
			

		return true;
	}

	public static void main(String[] args) {
		if(isAnagram("VI1SHAL", "VILASH"))
			System.out.println("True");
		else
			System.out.println("False");
	}
}
