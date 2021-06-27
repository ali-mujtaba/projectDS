/* 
    Find the minimum number of insertions and deletions
    to make string s1 from string s2.
*/
package com.practice.dp;

public class MinInsertionsAndDeletions {
    public static void main(String[] args) {
        // String s1 = "heap";
        // String s2 = "pea";

        // String s1 = "appoint"; 
        // String s2 = "point";
        
        // String s1 = "prop"; 
        // String s2 = "property";
        
        String s1 = "allergy"; 
        String s2 = "lego";
        
        calculate(s1,s2);

    }

    public static void calculate(String s1, String s2) {
        System.out.println("Deletions:" + (s2.length() - getLCSLength(s1, s2)));
        System.out.println("Insertions:" + (s1.length() - getLCSLength(s1, s2)));

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
