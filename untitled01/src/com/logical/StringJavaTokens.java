package com.logical;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String[] strArr = s.trim().split("[!,?._'@ ]+");
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strArr));
        System.out.println(strList.size());

        for(String str : strList)
            System.out.println(str);

        scan.close();
    }
}

input 	--> "He is a very very good boy, isn't he?" 
//remove all spaces and Special characters from this given String
output 	-->
	10
	He
	is
	a
	very
	very
	good
	boy
	isn
	t
	he
