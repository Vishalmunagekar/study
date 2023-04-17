package com.logical;//create new str by removing Duplicate caracters and return length of new str;

public class DuplicateCharacters {
	
	public static boolean contains(StringBuffer sb, char ch)
	{
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) == ch)
				return true;
		}
		return false;
	}
	
	public static int DuplicateCharacter(String str1)
	{
		String str = str1.toLowerCase();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.length(); i++)
		{
			if(contains(sb ,str.charAt(i)))
			{
				sb.append(str.charAt(i));
			}
		}
		return sb.length();
	}
	
	public static void main(String[] args) {
		String str = "babababa";	
		System.out.println(DuplicateCharacter(str));
	}
}

//input		--> babababa //this String only contains b and a
//output	--> 2
