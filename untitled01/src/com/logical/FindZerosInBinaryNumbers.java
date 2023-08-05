package com.logical;

public class FindZerosInBinaryNumbers {
	public static int FindCount(int L,int N, int K)
	{
		int count = 0;
		for(int i = L; i <= N; i++)
		{
			int n = i;
			String x = "";
			
			while(n > 0)
			{
				x = x + (n % 2);
				n = n / 2;
			}
			if(x.contains(Integer.toString(K)))
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int L = 1, N = 7, K = 0;
		System.out.println(FindCount(L, N, K));
	}
}
