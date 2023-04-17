package com.logical;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void findDistinct(int[] arr)
	{
		int arr1[] = new int[arr.length];
		int k = 0, count = 0;
		for(int i = 0 ; i < arr.length; i++) {
			int j;
			for(j = 0; j < i; j++)
				if(arr[i] == arr[j]) {
					break;
				}
			if(i == j) {
				arr1[k++] = arr[j];
				count++;
			}
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(count);
	}
	
	public static void findDistinctHashMap(int[] arr)
	{
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0 ; i < arr.length; i++)
			hm.put(arr[i], i);
		System.out.println(hm.keySet());
		System.out.println(hm.size());
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3, 10,2,5,8,6,5,7,8,10,16,2};
		findDistinct(arr);
		findDistinctHashMap(arr);
	}
}