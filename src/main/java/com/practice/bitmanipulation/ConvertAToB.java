package com.practice.bitmanipulation;

public class ConvertAToB {
	public static void main(String[] args) {
		System.out.println("Bits required: " + getBitsRequired(14, 31));
		System.out.println("Bits required: " + bitSwapRequired(14, 31));
	}

	static int getBitsRequired(int A, int B) {
		return BitManipulation.countSetBits(A ^ B);
	}

	static int bitSwapRequired(int A, int B) {
		int count = 0;
		for (int i = A ^ B; i != 0; i = i & (i - 1)) {
			count++;
		}

		return count;
	}
}