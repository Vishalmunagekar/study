package com.logical;

public class FindSmallestAndLargestNumber {

    public static void main(String[] args) {
        int arr[] = {1, 20,40,60,30,80,90,30,60};
        int small = 65536;
        int large = -65535;
        for(int i = 0; i < arr.length; i++){
            if(large < arr[i]){
                large = arr[i];
            }
            if(small > arr[i]){
                small = arr[i];
            }
        }
        System.out.println("small :" + small + "  large : " + large);
    }
}
