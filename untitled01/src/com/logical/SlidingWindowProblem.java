package com.logical;

public class SlidingWindowProblem {

//    Sliding window problem
//    Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
//    Output: 3 3 4 5 5 5 6
//    Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
//    Output: 10 10 10 15 15 90 90
//    Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 2
//    Output: 8 10 10 9 9 15 15 90 90

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int K1 = 3;
        System.out.print("Output for arr1: ");
        printMaxInSlidingWindow(arr1, K1);
        System.out.println();

        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int K2 = 4;
        System.out.print("Output for arr2: ");
        printMaxInSlidingWindow(arr2, K2);
        System.out.println();

        int[] arr3 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int K3 = 2;
        System.out.print("Output for arr3: ");
        printMaxInSlidingWindow(arr3, K3);
    }

    private static void printMaxInSlidingWindow1(int[] arr, int k) {
        int lenght = arr.length;

        for(int i = 0; i <= lenght - k; i++){
            int max = arr[i];
            for(int j = 1; j < k; j++){
                if(arr[i + j] > max){
                    max = arr[i + j];
                }
            }
            System.out.print(max + " ");
        }
    }

    private static void printMaxInSlidingWindow(int[] arr, int k) {
        int length = arr.length;

        for (int i = 0; i <= length - k; i++){
            int max = arr[i];
            for(int j = 1; j < k; j++){
                if(arr[i + j] > max){
                    max = arr[i + j];
                }
            }
            System.out.print(max + " ");
        }
    }

}
