/* 
    Given two strings, find their shortest common supersequence.
*/
package com.practice.dp;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        // String s1 = "geek";
        // String s2 = "eke";
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(getLength(s1, s2));
    }

    public static int getLength(String s1, String s2) {
        return s1.length() + s2.length() - getLCSLength(s1, s2);
    }

    private static int getLCSLength(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] memory = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1 + 1; i++) {
            memory[i][0] = 0;
        }
        for (int j = 0; j < l2 + 1; j++) {
            memory[0][j] = 0;
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    memory[i][j] = 1 + memory[i - 1][j - 1];
                } else {
                    memory[i][j] = Math.max(memory[i - 1][j], memory[i][j - 1]);
                }
            }
        }

        return memory[l1][l2];
    }

}
