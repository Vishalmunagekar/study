package com.logical;

public class StringAnagramWithoutMethods {
	static String charSort(char[] ch)
	{
		char temp = 0;
		for (int i = 0; i < ch.length; i++)
		{
			for (int j = 0; j < ch.length; j++)
			{
				if (ch[j] > ch[i])
				{
					temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp;
				}
			}
		}
		String newString = new String(ch);
		return newString;
	}

	static boolean isAnagram(String A, String B) {
		if(A.length() != B.length())
			return false;

		A=A.toLowerCase();
		B=B.toLowerCase();

		boolean f = false;

		char[] c = A.toCharArray();
		char[] d = B.toCharArray();

		String a = charSort(c);
		String b = charSort(d);

		if (a.equals(b)) {
			f=true;
		}
		return f;

	}
}
