/* 
    Find if there exists a subset of a given set of numbers which has a specific sum
*/
package com.practice.dp;

public class SubsetSum {
    public static void main(String[] args) {
        int[] items = { 2, 3, 7, 8, 10 };
        int target = 11;

        System.out.println(hasSubset(items, target));
        System.out.println(hasSubsetDP(items, target));

    }

    public static boolean hasSubset(int[] items, int target) {
        // return helper(items, target,items.length);

        int[][] memory = new int[items.length + 1][target + 1];
        initMemory(memory);
        int ans = helperMemoized(items, target, items.length, memory);
        if (ans == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean helper(int[] items, int target, int n) {
        // if no items and target > 0, then subset not possible
        if (n == 0 && target > 0) {
            return false;
        }

        // if target is 0, then empty set is always a subset irrelevant of no. of items
        if (target == 0) {
            return true;
        }

        boolean skippingCurrentItem = helper(items, target, n - 1);
        if (!skippingCurrentItem && items[n - 1] <= target) {
            boolean includingCurrentItem = helper(items, target - items[n - 1], n - 1);
            return includingCurrentItem;
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

    private static int helperMemoized(int[] items, int target, int n, int[][] memory) {
        // if no items and target > 0, then subset not possible
        if (n == 0 && target > 0) {
            return 0;
        }

        // if target is 0, then empty set is always a subset irrelevant of no. of items
        if (target == 0) {
            return 1;
        }

        if (memory[n][target] != -1) {
            return memory[n][target];
        }

        int skippingCurrentItem = helperMemoized(items, target, n - 1, memory);
        if (skippingCurrentItem == 0 && items[n - 1] <= target) {
            int includingCurrentItem = helperMemoized(items, target - items[n - 1], n - 1, memory);
            return memory[n][target] = includingCurrentItem;
        }

        return memory[n][target] = skippingCurrentItem;
    }

    public static boolean hasSubsetDP(int[] items, int target) {
        boolean[][] memory = new boolean[items.length + 1][target + 1];
        
        // initializing with trivial cases
        // if target=0, empty subset always exists so n is irrelevant
        // if n=0, subset will only exist for target=0
        for (int i = 0; i < items.length + 1; i++) {
            memory[i][0] = true;
        }

        for (int i = 1; i < items.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j >= items[i - 1]) {
                    memory[i][j] = memory[i - 1][j - items[i - 1]] || memory[i - 1][j];
                } else {
                    memory[i][j] = memory[i - 1][j];
                }
            }
        }
        return memory[items.length][target];
    }
}