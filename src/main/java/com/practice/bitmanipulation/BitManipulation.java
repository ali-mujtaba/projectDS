package com.practice.bitmanipulation;

public class BitManipulation {
	public static void main(String[] args) {
		System.out.println(getBit(22, 3));
		System.out.println(getBit(22, 4));
		System.out.println(setBit(22, 3));
		System.out.println(setBit(22, 4));
		System.out.println(clearBit(22, 3));
		System.out.println(clearBit(22, 4));
		System.out.println(clearMSBThroughI(22, 3));
		System.out.println(clearMSBThroughI(22, 2));
		System.out.println(clearIThroughLSB(22, 3));
		System.out.println(clearIThroughLSB(30, 2));
		System.out.println(updateBit(22, 3, 0));
		System.out.println(updateBit(22, 3, 1));
		System.out.println(countSetBits(0));
		System.out.println(countSetBits(32));
		System.out.println(countSetBits(31));
		System.out.println(countSetBits(22));
		System.out.println(getBinaryString(-22));
	}

	public static boolean getBit(int n, int i) {
		int mask = 1 << i;

		return ((n & mask) != 0);
	}

	public static int setBit(int n, int i) {
		int mask = (1 << i);

		return (n | mask);
	}

	public static int clearBit(int n, int i) {
		int mask = ~(1 << i);

		return n & mask;
	}

	public static int clearMSBThroughI(int n, int i) {
		// includes i
		int mask = (1 << i) - 1;

		return n & mask;
	}

	public static int clearIThroughLSB(int n, int i) {
		int mask = ~((1 << (i + 1)) - 1);

		return n & mask;
	}

	public static int updateBit(int n, int i, int v) {

		return clearBit(n, i) | (v << i);
	}

	public static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			count += n % 2;
			n = n / 2;
		}

		return count;
	}

	public static String getBinaryString(int n) {
		String bin = "";

		if (n < 0) {
			for (int i = 0; i < 32; i++) {
				bin = getBit(n, i) ? "1" + bin : "0" + bin;
			}
			return bin;
		}
		while (n != 0) {
			bin = (n % 2) + bin;
			n = n / 2;
		}

		return bin;
	}
}