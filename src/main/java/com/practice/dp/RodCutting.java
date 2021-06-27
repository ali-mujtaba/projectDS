/* 
    Find the max. value that can be fetched by selling
    pieces of a rod of length L, given prices for lengths 1 to L(both inclusive)
*/
package com.practice.dp;

public class RodCutting {
    public static void main(String[] args) {
        // int[] prices = {1,5,8,9,10,17,17,20};
        int[] prices = { 3, 5, 8, 9, 10, 17, 17, 20 };

        int rodLength = 8;
        System.out.println(maxValue(prices, rodLength));
    }

    public static int maxValue(int[] prices, int L) {
        int[][] memory = new int[prices.length + 1][L + 1];

        for (int i = 0; i < prices.length + 1; i++) {
            memory[i][0] = 0;
        }
        for (int j = 0; j < L + 1; j++) {
            memory[0][j] = 0;
        }

        for (int i = 1; i < prices.length + 1; i++) {
            for (int j = 1; j < L + 1; j++) {
                memory[i][j] = memory[i - 1][j];
                if (i <= j) {
                    memory[i][j] = Math.max(memory[i][j], prices[i - 1] + memory[i][j - i]);
                }
            }
        }

        return memory[prices.length][L];
    }
}