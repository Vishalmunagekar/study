// Remove Charters from Number String
// Original String  = 78v43i05s27h72al
// New String 		= 7843052772

package com.logical;

import java.util.Scanner;

public class RemoveCharsFromNumberString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("Enter String : ");
		str = sc.nextLine();
		
		System.out.println("Original String : "+ str);
		System.out.println("New String : "+ convertStr(str));
	}

	private static String convertStr(String str) {
		StringBuffer sb = new StringBuffer(str);
		
		for(int i = 0; i < sb.length(); i++)
		{
			if(sb.charAt(i) < 48 || sb.charAt(i) > 57)
			{
				sb.deleteCharAt(i);
				i--;
			}
		}
		return sb.toString();
	}
}
