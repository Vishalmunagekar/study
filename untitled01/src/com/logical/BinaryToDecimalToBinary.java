package com.logical;

public class Main {
	public static void findBinary(int n) {
		int i = 0, binary[] = new int[15];
		while(n > 0)
		{
			binary[i] = n % 2;
			n = n / 2;
			i++;
		}
		for(int j = i-1; j >= 0; j--)
			System.out.print(binary[j]);
	}
	//using parseInt method
	public static void BinaryToDecimal1()
	{
		String number = "10001";
		//pass a number String and redix
		int decimal = Integer.parseInt(number, 2);
		System.out.println(decimal);
	}
	
	//using logic
	public static void BinaryToDecimal2()
	{
		int binary = 10001;
		int decimal = 0;
		int p = 0;
		while(true)
		{
			if(binary == 0)
				break;
			else
			{
				int temp = binary % 10;
				decimal += temp * Math.pow(2, p);
				binary = binary / 10;
				p++;
			}
		}
		System.out.println(decimal);
	}
	
	
	public static void main(String[] args) {
		int n = 17;
		findBinary(n);
		System.out.println();
		BinaryToDecimal1();
		BinaryToDecimal2();
	}
}
