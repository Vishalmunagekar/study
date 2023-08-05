package com.logical;

import java.util.Arrays;

public class ReverseArray {
	public static int[] reverseArray(int arr[])
	{
		int i =0, j= arr.length-1, temp;
		while(i < j)
		{
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int revarr[] = reverseArray(arr);
		System.out.println(Arrays.toString(revarr));
	}
}