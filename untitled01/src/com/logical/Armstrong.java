// Armstrong Number!!
//	153 = (1*1*1)+(5*5*5)+(3*3*3)  
//	where:  
//	(1*1*1)=1  
//	(5*5*5)=125  
//	(3*3*3)=27  
//	So:  
//	1+125+27=153  

//371

package com.logical;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		int r, sum = 0, temp, n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		n = sc.nextInt();
		temp = n;
		while(n > 0)
		{
			r = n % 10;
			sum = sum +(r * r * r);
			n = n / 10;
		}
		if(temp == sum)
			System.out.println("Armstrong Number!!");
		else
			System.out.println("Not an Armstrong Number!!");
	}

}
