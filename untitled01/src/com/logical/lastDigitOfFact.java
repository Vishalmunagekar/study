package com.logical;

public class lastDigitOfFact {
	public static int lastDigitOfFact(int n)
	{
		long fact = 1;
		for(int i = 1; i <= n; i++)
			fact *= i;
		String str = Long.toString(fact);
		System.out.println(str);
		int num = 0;
		for(int i = str.length()-1; i >= 0; i--) {
			if(str.charAt(i) != '0')
			{
				num = Integer.parseInt(String.valueOf(str.charAt(i)));
				return num;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(lastDigitOfFact(25));
	}
}