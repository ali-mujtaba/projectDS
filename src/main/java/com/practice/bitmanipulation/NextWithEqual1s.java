package com.practice.bitmanipulation;

public class NextWithEqual1s {
	public static void main(String[] args) {
		System.out.println(getNextSmallest(204));
		System.out.println(getNextSmallest(21));
		System.out.println(getNextSmallest(22));
		System.out.println();
		System.out.println(getNextLargest(20));
		System.out.println(getNextLargest(211));
		System.out.println(getNextLargest(22));
	}

	// as in NEXT number
	static int getNextSmallest(int n) {
		boolean flag = false;
		int count0s = 0; // keeps count of the number of 0s encountered before 1st set bit
		for (int i = 0; i < 32; i++) {
			boolean currentBit = BitManipulation.getBit(n, i);

			if (currentBit) {
				flag = true;
				continue;
			}


			if (flag && ! currentBit) {
				n = BitManipulation.clearBit(n, i - 1);
				n = BitManipulation.setBit(n, i);
				i -= 2;

				// getting next smallest value even closer to n
				while (count0s > 0) {
					n = BitManipulation.clearBit(n, i);
					count0s--;
					i--;
				}
				while (i >= 0) {
					n = BitManipulation.setBit(n, i);
					i--;
				}

				return n;
			}

			count0s++;

		}

		return Integer.MAX_VALUE;
	}

	// as in PREV number
	static int getNextLargest(int n) {
		boolean flag = false;
		int count1s = 0; // keeps count of the number of 1s encountered before 1st clear bit

		for (int i = 0; i < 32; i++) {
			boolean currentBit = BitManipulation.getBit(n, i);

			if (!currentBit) {
				flag = true;
				continue;
			}

			if (flag && currentBit) {
				n = BitManipulation.clearBit(n, i);
				n = BitManipulation.setBit(n, i - 1);
				i -= 2;

				// getting next largest value even closer to n
				while (count1s > 0) {
					n = BitManipulation.setBit(n, i);
					count1s--;
					i--;
				}
				while (i >= 0) {
					n = BitManipulation.clearBit(n, i);
					i--;
				}

				return n;
			}
			count1s++;
		}

		return Integer.MIN_VALUE;
	}
}