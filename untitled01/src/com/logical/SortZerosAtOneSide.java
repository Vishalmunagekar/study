package com.logical;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortZerosAtOneSide {


		public static int[] sortArray(int arr[])
		{
			int itr = 0;
			int com = 0;
			for(int i = 0; i < arr.length; i++)
			{
				for(int j = i + 1; j < arr.length; j++)
				{
					itr++;
					if(arr[i] == 1) {
						com++;
						if(arr[j] == 0)
						{
							int temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
							break;
						}
					}
				}
			}
			System.out.println("Iteration   : " + itr);
			System.out.println("Comparision : " + com);
			return arr;
		}
		public static void main(String[] args) {
			int arr[] = {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0};
			int arr1[] = sortArray(arr);
			System.out.println(Arrays.toString(arr1));
		}

// output :
//Iteration   : 44
//Comparision : 44
//[0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1]
}