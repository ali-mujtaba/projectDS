/* 
    Given a set of coins, find the min. no. of coins required to provide change for an value 'x'
    using the given set of coins;
*/
package com.practice.dp;

public class CoinChangeMinCoins {
    public static void main(String[] args) {
        int[] coins = { 25, 10, 5 };
        int x = 30;
        System.out.println(getMinCoins(coins, x));
    }

    public static int getMinCoins(int[] coins, int value) {
        int[][] memory = new int[coins.length + 1][value + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            memory[i][0] = 0;
        }

        for (int j = 0; j < value + 1; j++) {
            memory[0][j] = Integer.MAX_VALUE - 1; // MAX_VALUE-1, to avoid INT rollover on adding 1 later
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < value + 1; j++) {
                memory[i][j] = memory[i - 1][j];
                if (j >= coins[i - 1]) {
                    memory[i][j] = Math.min(memory[i][j], 1 + memory[i][j - coins[i - 1]]);
                }
            }
        }

        return memory[coins.length][value];
    }
}
