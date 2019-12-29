package com.practice.backtracking;

import java.util.Stack;
public class SubsetSum {

	int k;
	int[] set;
	Stack<Integer> subset;

	SubsetSum(int[] s, int k) {
		this.k = k;
		set = s;
		subset = new Stack<>();
	}

	public static void main(String[] args) {
		int[] arr = {15, 22, 14, 26, 32, 9, 16, 8}; // set of unique numbers
		int sum = 53; // target sum

		System.out.print("Set: {");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("\b\b}");
		System.out.println("Target sum: " + sum);

		SubsetSum ss1 = new SubsetSum(arr, sum);
		if (!ss1.findSubset(0, 0)) {
			System.out.println("Solution does not exist!");
			return;
		}
		System.out.println("Subset: " + ss1.subset);
	}


	boolean findSubset(int currentIndex, int sum) {
		if (sum == k) {
			return true;
		}

		// checking all possible subsets in decreasing order of size

		for (int i = currentIndex; i < set.length; i++) {
			subset.push(set[i]);
			sum += set[i];
			if (findSubset(currentIndex + 1, sum)) {
				return true;
			}

			// backtrack because the element at currentIndex does not belong to our required subset
			sum -= set[i];
			subset.pop();
		}

		return false;
	}
}