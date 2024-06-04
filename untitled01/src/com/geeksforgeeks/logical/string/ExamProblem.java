package com.geeksforgeeks.logical.string;

public class ExamProblem {

//input1 = 5
//input2 = 3
//input3 = {2,1,5,3,4}

//    1*2 + 1*1 + 1*5 = 8
//    1*1 + 1*5 + 1*3 = 9
//    1*5 + 1*3 + 1*4 = 12

//input1 = 4
//input2 = 2
//input3 = {-2,1,5,3}





    public static void main(String[] args) {
        System.out.println(findBestScore(5, 3, new int[]{2, 1, 5, 3, 4}));
    }

    public static int findBestScore(int input1, int input2, int[] input3){
        int max = 0;
        for(int i =0; i < input1; i++){
            int val = 0;
            for(int j = 1; j <= input2; j++){
                val = val + (j * input3[j]);
            }
            if(val > max) max = val;
        }
        return max;
    }
}
