/* 
    Unbounded Knapsack
*/
package com.practice.dp;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = { 10, 20, 30 };
        int[] value = { 60, 100, 120 };
        int capacity = 50;

        // int[] weight = { 5, 4, 6, 3 };
        // int[] value = { 10, 40, 30, 50 };
        // int capacity = 10;

        System.out.println(knapsack(value, weight, capacity));
    }

    public static int knapsack(int[] value, int[] weight, int capacity) {
        int[][] memory = new int[weight.length + 1][capacity + 1];

        for (int i = 0; i < weight.length + 1; i++) {
            memory[i][0] = 0;
        }

        for (int j = 0; j < capacity + 1; j++) {
            memory[0][j] = 0;
        }

        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                memory[i][j] = memory[i - 1][j];
                if (j >= weight[i - 1]) {
                    memory[i][j] = Math.max(memory[i][j], value[i - 1] + memory[i][j - weight[i - 1]]);
                }
            }
        }

        return memory[weight.length][capacity];
    }
}