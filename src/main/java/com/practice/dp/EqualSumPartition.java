/* 
    Find out if a given set of numbers can be partitioned into two exclusive sets having equal sum
*/
package com.practice.dp;

public class EqualSumPartition {
    public static void main(String[] args) {
        // int[] arr = {1,5,11,5,1};
        int[] arr = { 1, 5, 11, 5 };
        System.out.println(exists(arr));
    }

    public static boolean exists(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if ((sum & 1) == 1) {
            return false;
        }

        if (hasSubset(arr, sum / 2)) {
            return true;
        }

        return false;

    }

    private static boolean hasSubset(int[] arr, int target) {
        boolean[][] memory = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            memory[i][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                memory[i][j] = memory[i - 1][j];
                if (arr[i - 1] <= j) {
                    memory[i][j] = memory[i][j] || memory[i - 1][j - arr[i - 1]];
                }
            }
        }
        // showMemory(memory);
        return memory[arr.length][target];
    }

    private static void showMemory(boolean[][] mem) {
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                System.out.print(mem[i][j] + "\t");
            }
            System.out.println();
        }
    }
}