/* 
    Count the pair of subsets which have a given difference.
*/
package com.practice.dp;

public class CountSubsetsWithDiff{
    public static void main(String[] args){
        int[] arr = {1,1,2,3};
        int targetDifference = 1;
        System.out.println(count(arr,targetDifference));
    }

    public static int count(int[] arr, int diff){
        if(arr.length==0){
            return 0;
        }

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }

        // S1 = sum(subset1) and S2 = sum(subset2); 
        // S1<S2, if not, then exchange S1 and S2
        // S1+S2 = sum; S1-S2 = diff => S1 = (sum-diff)/2 and S2 = (sum+diff)/2

        // if S1/S2 are complementary even/odd => sum = odd, diff = odd
        // if S1/S2 both even/odd => sum = even, diff = even

        // if sum/diff aren't both even or both odd => subset pairs don't exist
        if(((sum&1) ^ (diff&1))==0){
            int S1 = (sum-diff)/2;
            return countSubsetsHavingSum(arr,S1);
        }

        return 0;
    }

    public static int countSubsetsHavingSum(int[] arr, int sum){
        int[][] memory = new int[arr.length+1][sum+1];
        for(int j=0;j<sum+1;j++){
            memory[0][j] = 0;
        }
        for(int i=0;i<arr.length+1;i++){
            memory[i][0] = 1;
        }

        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                memory[i][j]+=memory[i-1][j];
                if(j>=arr[i-1]){
                    memory[i][j]+=memory[i-1][j-arr[i-1]];
                }
            }
        }

        return memory[arr.length][sum];
    }

}