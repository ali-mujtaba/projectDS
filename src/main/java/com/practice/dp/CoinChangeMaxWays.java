/* 
    Given a set of coins, find the max.no. of ways to provide change for an value 'x'
    using the given set of coins;
*/
package com.practice.dp;

public class CoinChangeMaxWays {
    public static void main(String[] args) {
        // int[] coins = {1,2,3};
        // int x = 4;
        int[] coins = { 2, 3, 5, 6 };
        int x = 10;
        System.out.println(countWays(coins, x));
    }

    public static int countWays(int[] coins, int value) {
        int[][] memory = new int[coins.length + 1][value + 1];

        for (int j = 0; j < value + 1; j++) {
            memory[0][j] = 0;
        }
        for (int i = 0; i < coins.length + 1; i++) {
            memory[i][0] = 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < value + 1; j++) {
                memory[i][j] += memory[i - 1][j];
                if (j >= coins[i - 1]) {
                    memory[i][j] += memory[i][j - coins[i - 1]];
                }
            }
        }

        return memory[coins.length][value];
    }
}
