/* 
    Given two strings, find their longest common subsequence.
*/
package com.practice.dp;

import java.util.ArrayList;
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        // String s1="abc";
        // String s2="cb";
        // String s1="abcde";
        // String s2="ace";
        // // String s1="abc";
        // String s2="bc";
        // String s1="";
        // String s2="";
        String s1="abaaa";
        String s2="baabaca";
        System.out.println(getLength(s1,s2));
        System.out.println(getASubsequence(s1,s2));
        System.out.println(getSubsequences(s1,s2));

    }

    public static int getLength(String s1, String s2){
        // return helper(s1,s2,s1.length(),s2.length());

        // int[][] memory = new int[s1.length()+1][s2.length()+1];
        // initMemory(memory);
        // return helperMemoized(s1,s2,s1.length(),s2.length(),memory);
        
        
        
        return helperDP(s1,s2,s1.length(),s2.length());
    }

    private static int helper(String s1, String s2, int l1, int l2) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 2)) {
            // when the last character of both string is the same,
            // it will become part of the subsequence
            // and they will be removed from further consideration

            return 1 + helper(s1, s2, l1 - 1, l2 - 1);
        } else {
            // in case of different last characters,
            // we'll find out reducing which string gives greater common subsequence

            return Math.max(helper(s1, s2, l1 - 1, l2), helper(s1, s2, l1, l2 - 1));
        }
    }

    private static int helperMemoized(String s1, String s2, int l1, int l2, int[][] memory) {
        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        if (memory[l1][l2] != -1) {
            return memory[l1][l2];
        }

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            // when the last character of both string is the same,
            // it will become part of the subsequence
            // and they will be removed from further consideration

            memory[l1][l2] = 1 + helperMemoized(s1, s2, l1 - 1, l2 - 1,memory);
        } else {
            // in case of different last characters,
            // we'll find out reducing which string gives greater common subsequence

            memory[l1][l2] = Math.max(helperMemoized(s1, s2, l1 - 1, l2, memory), helperMemoized(s1, s2, l1, l2 - 1, memory));
        }

        return memory[l1][l2];
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


    public static int helperDP(String s1, String s2, int l1, int l2) {
        int[][] memory = new int[l1 + 1][l2 + 1];

        // initializing trivial cases

        // when s2 is empty string, there will be no subsequence,
        // hence length of subsequence =0
        for (int i = 0; i < l1 + 1; i++) {
            memory[i][0] = 0;
        }

        // when s1 is empty string, there will be no subsequence,
        // hence length of subsequence =0
        for (int j = 0; j < l2 + 1; j++) {
            memory[0][j] = 0;
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // when char at s1[i] and s2[j] are equal, add them to subsequence string
                    memory[i][j] = 1 + memory[i - 1][j - 1];
                } else {
                    memory[i][j] = Math.max(memory[i - 1][j], memory[i][j - 1]);
                }
            }
        }

        return memory[l1][l2];
    }

    public static String getASubsequence(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length();
        int[][] memory = new int[l1 + 1][l2 + 1];

        // initializing trivial cases

        // when s2 is empty string, there will be no subsequence,
        // hence length of subsequence =0
        for (int i = 0; i < l1 + 1; i++) {
            memory[i][0] = 0;
        }

        // when s1 is empty string, there will be no subsequence,
        // hence length of subsequence =0
        for (int j = 0; j < l2 + 1; j++) {
            memory[0][j] = 0;
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // when char at s1[i] and s2[j] are equal, add them to subsequence string
                    memory[i][j] = 1 + memory[i - 1][j - 1];
                } else {
                    memory[i][j] = Math.max(memory[i - 1][j], memory[i][j - 1]);
                }
            }
        }

        // showMemory(memory);
        char[] sequence = new char[memory[l1][l2]];
        int p=sequence.length-1;
        int i=l1, j=l2;
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sequence[p] = s1.charAt(i-1);
                p--;
                i--; j--;
            }else{
                if(memory[i-1][j]>memory[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        
        }

        return new String(sequence);
    }

    public static ArrayList<String> getSubsequences(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length();
        int[][] memory = new int[l1 + 1][l2 + 1];

        // initializing trivial cases

        // when s2 is empty string, there will be no subsequence,
        // hence length of subsequence =0
        for (int i = 0; i < l1 + 1; i++) {
            memory[i][0] = 0;
        }

        // when s1 is empty string, there will be no subsequence,
        // hence length of subsequence =0
        for (int j = 0; j < l2 + 1; j++) {
            memory[0][j] = 0;
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // when char at s1[i] and s2[j] are equal, add them to subsequence string
                    memory[i][j] = 1 + memory[i - 1][j - 1];
                } else {
                    memory[i][j] = Math.max(memory[i - 1][j], memory[i][j - 1]);
                }
            }
        }

        // showMemory(memory);
       
        char[] sequence = new char[memory[l1][l2]];
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        list.add(new ArrayList<Character>());
        helper(s1,s2,l1,l2,memory,list);
        ArrayList<String> stringified = new ArrayList<>();
        for(ArrayList<Character> el: list){
            stringified.add(el.toString());
        }

        return stringified;
    }

    private static void helper(String s1, String s2, int l1, int l2, int[][] memory, ArrayList<ArrayList<Character>> list){
        if(l1==0 || l2==0){
            return;
        }

        if(s1.charAt(l1-1) == s2.charAt(l2-1)){
            helper(s1,s2,l1-1,l2-1, memory, list);
            for(ArrayList<Character> el : list){
                el.add(s1.charAt(l1-1));
            }
        }else{
            if(memory[l1-1][l2]==memory[l1][l2-1]){
                ArrayList<ArrayList<Character>> listClone = new ArrayList<>(list.size());
                for(ArrayList<Character> el: list){
                    listClone.add(new ArrayList<>(el));
                }

                helper(s1,s2,l1-1,l2,memory,list);
                helper(s1,s2,l1,l2-1,memory,listClone);
                list.addAll(listClone);

            }else{
                if(memory[l1-1][l2]>memory[l1][l2-1]){
                    helper(s1,s2,l1-1,l2, memory, list);  
                }else{
                    helper(s1,s2,l1,l2-1, memory, list);  
                }
            }
        }
    } 
}
