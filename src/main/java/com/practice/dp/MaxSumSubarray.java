package com.practice.dp;

import java.util.ArrayList;

public class MaxSumSubarray {
	private int globalMax;
	private final int[] arr;
	private ArrayList<Integer> maxSubarray;

	public MaxSumSubarray(int[] a) {
		arr = a;

		if (arr.length > 0) {
			globalMax = arr[0];
			maxSubarray = new ArrayList<>();
			maxSubarray.add(arr[0]);
			int localMax = arr[0];
			ArrayList<Integer> subarray = new ArrayList<>();
			subarray.add(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				if (localMax < 0) {
					subarray.clear();
					localMax = arr[i];
					subarray.add(arr[i]);
				} else {
					localMax += arr[i];
					subarray.add(arr[i]);
				}

				if (globalMax <= localMax) {
					globalMax = localMax;
					maxSubarray.clear();
					maxSubarray.addAll(subarray);
				}
			}
		}
	}

	public Iterable<Integer> subarray() {
		return maxSubarray;
	}
	public int sum() {
		return globalMax;
	}
	public static void main(String[] args) {
		int[] arr = {2, 2, -5, 7, 1, 9, -2, 1};
		// int[] arr = {2, 5, -5, 7, 1, 9, -2, 1};
		// int[] arr = {2, 5, -5, 7, 1, 9, -2, 2};
		// int[] arr = { -8, -3, -5, -7, -9, -1, -2, -4};
		MaxSumSubarray mss = new MaxSumSubarray(arr);
		System.out.println(mss.sum());
		System.out.println(mss.subarray());

	}
}