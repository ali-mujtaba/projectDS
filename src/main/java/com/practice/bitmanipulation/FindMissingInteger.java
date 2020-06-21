package com.practice.bitmanipulation;

public class FindMissingInteger {
	public static void main(String[] args) {
		int n = 10;
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = i;
		}
		A[n - 3] = n;
		System.out.print("Array: ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		System.out.println("Missing Integer: " + find(A, n));
	}

	static int find(int[] A, int n) {
		int missingInteger = 0;
		int k = (int)(Math.log(n) / Math.log(2));
		int factor = 1;

		for (int j = 0; j <= k; j++) {
			int m = n + 1;
			boolean flag = false;
			int required1s = 0;

			// calulates total number of 1s at j-th bit position of numbers 0 through n
			while (m >= factor) {
				if (flag) {
					required1s += factor;
				}
				m -= factor;
				flag = !flag;
			}

			if (flag) {
				required1s += m;
			}

			// compare with total number of 1s in j-th bit of numbers in array
			for (int i = 0; i < n; i++) {
				if (jthBitOfAi(A, i, j)) {
					required1s--;
				}
			}

			// if total no. of 1s at j-th bit of array different from total no. of 1s from 0 through n
			// then missing number will have 1 at j-th place
			if (required1s != 0) {
				missingInteger = missingInteger | (1 << j);
			}

			// factor implies the number of consecutive appearances of 0s or 1s
			// at j-th position in 0 through n.
			factor *= 2;
		}

		return missingInteger;
	}

	static boolean jthBitOfAi(int[] A, int i, int j) {

		return BitManipulation.getBit(A[i], j);
	}
}