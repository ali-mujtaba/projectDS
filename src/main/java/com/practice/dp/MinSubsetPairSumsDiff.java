/* 
    Find the minimum difference between sums of mutually exclusive
    pair of subsets of a given set of numbers.
*/
package com.practice.dp;

public class MinSubsetPairSumsDiff {
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        // int[] arr = {11};
        // int[] arr = {11,12};
        // int[] arr = {11,12,13,14};
        System.out.println(findMinDiff(arr));
    }

    public static int findMinDiff(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        /* 
                S1=sum of elements in subset 1; similarly S2
                S1/S2 belong to (0,sum); S1<=S2, if S1>S2, exchange S1/S2
                min. possible diff = 0 if sum is even
                min. possible diff = 1 if sum is odd
                S2 = sum-S1 => diff = S2-S1 = sum-S1-S1 = sum-2*S1
                So, min(diff)=min(sum-2*S1)=> max(S1) = sum/2 since abs. diff. always >=0 
        */

        boolean[] subsetSumMemory = subsetSum(arr, sum / 2);
        // for(int i=0;i<subsetSumMemory.length;i++){
        //     System.out.print(subsetSumMemory[i]+" ");
        // }
        // System.out.println();
        
        for (int i = sum / 2; i > 0; i--) {
            if (subsetSumMemory[i]) {
                return sum - 2 * i;
            }
        }
        return sum;
    }

    public static boolean[] subsetSum(int[] arr, int s) {
        boolean[][] memory = new boolean[arr.length + 1][s + 1];

        for (int j = 0; j < s + 1; j++) {
            memory[0][j] = false;
        }

        for (int i = 0; i < arr.length + 1; i++) {
            memory[i][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                memory[i][j] = memory[i - 1][j];
                if (j >= arr[i - 1]) {
                    memory[i][j] = memory[i][j] || memory[i - 1][j - arr[i - 1]];
                }
            }
        }

        return memory[arr.length];
    }
}