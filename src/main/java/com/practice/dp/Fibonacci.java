package com.practice.dp;

public class Fibonacci {

	// top-down approach
	static long getFib(int n, long[] memory) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		if (memory[n] != 0) {
			return memory[n];
		}

		memory[n] = getFib(n - 1, memory) + getFib(n - 2, memory);
		return memory[n];
	}

	// bottom-up approach
	static long getFib(int n) {
		long[] fib = new long[n + 1];
		fib[0] = 0; fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib[n];
	}

	static long getFibBetter(int n) {
		if (n == 0) {
			return 0;
		}
		if (n <= 2) {
			return 1;
		}
		long nMinus1 = 1;
		long nMinus2 = 1;
		long fib = nMinus1 + nMinus2;
		for (int i = 4; i <= n; i++) {
			nMinus2 = nMinus1;
			nMinus1 = fib;
			fib = nMinus1 + nMinus2;
		}

		return fib;
	}
	public static void main(String[] args) {
		System.out.println(getFib(6, new long[7]));
		System.out.println(getFib(50, new long[51]));
		System.out.println(getFib(6));
		System.out.println(getFib(50));
		System.out.println(getFibBetter(6));
		System.out.println(getFibBetter(50));
	}
}