// Implementation of Counting Sort Algorithm

import java.util.*;
public class CountingSort {
	public static void main(String[] args) {
		int[] arr = {10, 7, 12, 4, 9, 13, 9};
		System.out.print("\nProvided array is as follows: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		arr = sort(arr);
		System.out.print("\nSorted array is as follows: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	static int[] sort(int arr[]) {
		int n = arr.length;
		int max = 0, min = 9999;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		int rs = max - min + 1;
		int[] count = new int[rs];

		for (int i = 0 ; i < n; i++)
			count[arr[i] - min]++;


		int[] sumCount = new int[rs];
		sumCount[rs - 1] = count[rs - 1];

		for (int i = max - min - 1; i >= 0; i--)
			sumCount[i] = count[i] + sumCount[i + 1];

		int[] sortedArr = new int[n];
		for (int i = 0; i < n; i++) {
			int pos = sumCount[arr[i] - min];
			sortedArr[pos - 1] = arr[i];
			sumCount[arr[i] - min]--;
		}

		// following up on intermediate steps
		// System.out.println("Max: " + max + "\nMin: " + min);
		// System.out.println("Range \t Count \t sumCount");
		// for (int i = 0; i < rs; i++) {
		// 	System.out.println((min + i) + " \t " + count[i] + " \t " + sumCount[i]);
		// }

		return sortedArr;

	}
}