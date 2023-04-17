//String Compression by Using HashMap

package com.logical;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
	public static String Repetation(String str1)
	{
		String str = str1.toUpperCase();
		StringBuffer sb = new StringBuffer();
		Map<Character, Integer> cmap = new HashMap<>();
		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if(cmap.containsKey(ch))
			{
				int count = cmap.get(ch);
				cmap.put(ch, ++count);
			}
			else
			{
				cmap.put(ch, 1);
			}
		}
		int cnt;
		for(Character ch : cmap.keySet()) {
			cnt = cmap.get(ch);
			sb.append(cnt);
			sb.append(ch);
		}
		//System.out.println(sb);
		return sb.toString();
	}
	public static void main(String[] args) {
		String str = "abbdddeeeefffff";
		String newstr = Repetation(str);
		System.out.println(newstr);
	}

}

Input 	--> abbdddeeeefffff
Output	--> 1A2B3D4E5F


imp methods

HashMap.get(key) 			<-- return value
HashMap.containsKey(key) 	<-- return true or false
HashMap.put(key, value)		<-- insrt new key value
HashMap.keySet()			<-- return whole keys

