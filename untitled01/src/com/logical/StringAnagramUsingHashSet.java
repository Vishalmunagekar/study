package com.logical;

import java.util.HashSet;
import java.util.Set;

public class StringAnagramUsingHashSet {

	public static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		Set<Character> hs1 = new HashSet<>();
		Set<Character> hs2 = new HashSet<>();
		
		for(int i = 0; i < str1.length(); i++)
		{
			hs1.add(str1.charAt(i));
			hs2.add(str2.charAt(i));
		}
		
		if(hs1.equals(hs2))
			return true;
		
		return false;
	}
	public static void main(String[] args) {
		String str1 = "VISHAL";	//"LISTEN";
		String str2 = "VIALSH";	//SILENT";
		System.out.println(isAnagram(str1, str2));
	}

}
