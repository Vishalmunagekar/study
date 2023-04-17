package com.logical;

public class FindMinMax {

	public static void main(String[] args) {
		int arr[] = new int[] {110,10,20,30,70,150,80,90,40,60,100};
		int max1 = arr[0]; int max1Index = 0;
		int max2 = arr[0];
		int min  = arr[0]; int minIndex  = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max1)
			{
				max2 = max1;
				max1 = arr[i];
				max1Index = i;
				
			} else if(arr[i] > max2 && arr[i] < max1)
			{
				max2 = arr[i];
			}


			if(arr[i] < min)
			{
				min = arr[i];
				minIndex = i;
			}
		}
		System.out.println("Largest: " + max1 + " Index :"+ max1Index);
		System.out.println("2nd Largest : " + max2);
		System.out.println("Smallest : " + min+ " Index : "+ minIndex);
	}
}
