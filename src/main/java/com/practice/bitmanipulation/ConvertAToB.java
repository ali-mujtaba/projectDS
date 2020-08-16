package com.practice.bitmanipulation;

public class ConvertAToB {
	public static void main(String[] args) {
		System.out.println("Bits required: " + getBitsRequired(14, 31));
	}

	static int getBitsRequired(int A, int B) {
		return BitManipulation.countSetBits(A ^ B);
	}
}