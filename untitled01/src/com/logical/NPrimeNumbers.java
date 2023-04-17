package com.logical;

public class Main {
	public static void printPrime(int n)
	{
		boolean isPrime;
		for(int i = 2; i <= n; i++)
		{
			isPrime = isPrime(i);
			if(isPrime)
				System.out.print(i + " ");
		}
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
		printPrime(100);
	}
}
