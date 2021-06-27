/* 
    From a given set of numbers, count the number of subsets that equal to a target sum
*/
package com.practice.dp;

public class CountSubsets {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int target = 10;
        System.out.println(countSubsets(arr, target));
        System.out.println(countSubsetsDP(arr, target));

    }

    public static int countSubsets(int[] arr, int target) {
        int[][] memory = new int[arr.length + 1][target + 1];
        initMemory(memory);
        return helper(arr, target, arr.length, memory);
    }

    private static int helper(int[] arr, int target, int n, int[][] memory) {
        if (n == 0 && target > 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }

        if (memory[n][target] != -1) {
            return memory[n][target];
        }

        memory[n][target] = helper(arr, target, n - 1, memory);
        if (target >= arr[n - 1]) {
            memory[n][target] += helper(arr, target - arr[n - 1], n - 1, memory);
        }

        return memory[n][target];
    }

    public static int countSubsetsDP(int[] arr, int target) {
        int[][] memory = new int[arr.length + 1][target + 1];
        /*
         * if the set is empty, count of subsets with target sum would be nil except if
         * target = 0, in which case no. of subsets would be 1, ie, empty set
         */
        for (int i = 0; i < target + 1; i++) {
            memory[0][i] = 0;
        }

        /*
         * to attain target=0, one and only subset exists irresepective of no. of items,
         * ie, empty subset
         */

        for (int i = 0; i < arr.length + 1; i++) {
            memory[i][0] = 1;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                memory[i][j] = memory[i - 1][j];
                if (j >= arr[i - 1]) {
                    memory[i][j] += memory[i - 1][j - arr[i - 1]];
                }
            }
        }

        return memory[arr.length][target];

    }

    private static void initMemory(int[][] mem) {
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                mem[i][j] = -1;
            }
        }
    }

}