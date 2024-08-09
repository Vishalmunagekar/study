package com.sortingalogs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{9,6,3,2,1,5,4,7,8};

        for(int i = 0; i < (arr.length - 1); i++){
            for(int j = 0; j < (arr.length - i - 1); j++ ){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        for(int i = 0; i < (arr.length - 1); i++){
            for(int j = 0; j < (arr.length - i -1); j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);

    } 

}