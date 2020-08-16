package com.practice.bitmanipulation;

public class InsertMIntoN {
	public static void main(String[] args) {

		int M = 19;
		int N = 1024;
		int i = 2;
		int j = 6;

		System.out.println(BitManipulation.getBinaryString(insertMIntoN(M, N, i, j)));
	}

	public static int insertMIntoN(int M, int N, int i, int j) {

		// insufficient space in N between 'i' and 'j' to insert M
		if (getMinBits(M) > (Math.abs(j - i) + 1)) {
			return N;
		}

		if (i > j) {
			int t = i;
			i = j;
			j = t;
		}

		N = clearBits(N, i, j);

		return N | (M << i);
	}

	// clears bits i through j
	static int clearBits(int N, int i, int j) {
		// int p = getMinBits(M);
		int p = j - i + 1;
		int mask = ~(((1 << p) - 1) << i);
		System.out.println();
		return N & mask;
	}

	// returns minimum no. of bits required to represent M
	static int getMinBits(int M) {
		int i = 1;
		while (M > 1) {
			M = M / 2;
			i++;
		}
		return M;
	}
}