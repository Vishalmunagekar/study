package com.logical;

public class StringCompression {
	public static boolean contains(StringBuffer sb, char ch)
	{
		char[] charSet = sb.toString().toCharArray();
		for(int i = 0; i < sb.length(); i++) {
			if(charSet[i] == ch)
				return true;
		}
		return false;
	}
	public static String findDuplicates(String str)
	{
		char[] charSet = str.toUpperCase().toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < charSet.length; i++)
		{
			int count = 1;
			for(int j = i + 1; j < charSet.length; j++)
			{
				if(charSet[i] == charSet[j])
				{
					count++;
				}
			}
			if(!contains(sb, charSet[i])) {
				sb.append(count);
				sb.append(charSet[i]);
			}
		}
		System.out.println(sb);
		return null;
	}
	public static void main(String[] args) {
		String str = "abbcccdddd";
		findDuplicates(str);
	}

}
Input	--> abbcccdddd
Output	--> 1A2B3C4D


