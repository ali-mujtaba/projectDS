/* 
    0/1 Knapsack 
*/
package com.practice.dp;

public class Knapsack01 {
    public static void main(String[] args) {
        // int[] weight = {10,20,30};
        // int[] value = {60,100,120};
        // int capacity = 50;
        int[] weight = { 5, 4, 6, 3 };
        int[] value = { 10, 40, 30, 50 };
        int capacity = 10;

        System.out.println(knapsackRecursive(weight, value, capacity));
        System.out.println(knapsackDP(weight, value, capacity));

    }

    public static int knapsackRecursive(int[] weight, int[] value, int capacity) {
        // return helperRecursive(weight, value, capacity, weight.length);

        int[][] memory = new int[weight.length + 1][capacity + 1]; // 2-D because we have 2 varying arguments
        initMemory(memory);
        int ans = helperMemoized(weight, value, capacity, weight.length, memory);
        // display memory
        // showMemory(memory);

        return ans;
    }

    private static int helperRecursive(int[] weight, int[] value, int cap, int n) {
        // when bag has nil capacity or there are no items
        if (cap <= 0 || n <= 0) {
            return 0;
        }

        int skippingCurrentItem = helperRecursive(weight, value, cap, n - 1);

        // if weight of current item is less than capacity of knapsack
        // only then its possible to include it
        if (weight[n - 1] <= cap) {
            int includingCurrentItem = helperRecursive(weight, value, cap - weight[n - 1], n - 1);
            return Math.max(skippingCurrentItem, value[n - 1] + includingCurrentItem);
        }

        return skippingCurrentItem;
    }

    private static void initMemory(int[][] mem) {
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                mem[i][j] = -1;
            }
        }
    }

    private static void showMemory(int[][] mem) {
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                System.out.print(mem[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int helperMemoized(int[] weight, int[] value, int cap, int n, int[][] mem) {
        // when bag has nil capacity or there are no items
        if (cap <= 0 || n <= 0) {
            return 0;
        }

        if (mem[n][cap] != -1) {
            return mem[n][cap];
        }
        int skippingCurrentItem = helperMemoized(weight, value, cap, n - 1, mem);

        // if weight of current item is less than capacity of knapsack
        // only then its possible to include it
        if (weight[n - 1] <= cap) {
            int includingCurrentItem = helperMemoized(weight, value, cap - weight[n - 1], n - 1, mem);
            return mem[n][cap] = Math.max(skippingCurrentItem, value[n - 1] + includingCurrentItem);
        }

        return mem[n][cap] = skippingCurrentItem;
    }

    public static int knapsackDP(int[] weight, int[] value, int capacity) {
        int[][] memory = new int[weight.length + 1][capacity + 1];

        // initializing memory with trivial cases
        // when capacity = 0
        for (int i = 0; i < weight.length + 1; i++) {
            memory[i][0] = 0;
        }

        // when there are no weights to put in knapsack
        for (int i = 0; i < capacity + 1; i++) {
            memory[0][i] = 0;
        }

        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (weight[i - 1] <= j) {
                    memory[i][j] = Math.max(value[i - 1] + memory[i - 1][j - weight[i - 1]], memory[i - 1][j]);
                } else {
                    memory[i][j] = memory[i - 1][j];
                }
            }
        }

        // showMemory(memory);
        return memory[weight.length][capacity];
    }
}