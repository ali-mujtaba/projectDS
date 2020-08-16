package com.practice.bitmanipulation;

public class SwapOddEvenBits {
	public static void main(String[] args) {

		System.out.println(BitManipulation.getBinaryString(swapOddEvenBits(45)));
		System.out.println(BitManipulation.getBinaryString(swapOddEvenBits(22)));
	}

	static int swapOddEvenBits(int n) {

		for (int i = 0; i < 31; i += 2) {
			if (BitManipulation.getBit(n, i) != BitManipulation.getBit(n, i + 1)) {
				n = n ^ (3 << i);
			}
		}
		return n;
	}
}