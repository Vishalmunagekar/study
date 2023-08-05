package com.logical;

public class TwinPrimeNumbers {
	public static void printTwinPrime(int n)
	{
		int arr[] = new int[n/2], counter = 0;
		boolean isPrime;
		for(int i = 2; i <= n; i++)
		{
			isPrime = isPrime(i);
			if(isPrime)
				arr[counter++] = i;
		}
		for(int i = 0; i < n/2 - 1; i++)
			if((arr[i+1] - arr[i]) == 2)
				System.out.print("("+arr[i] +","+ arr[i+1]+")"+" ");
	}
	
	public static boolean isPrime(int num)
	{
		for(int i = 2; i <= num / 2; i++)
		{
			if((num % i) == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		//Twin Prime Numbers between 1 and n
		printTwinPrime(25);
	}
}
