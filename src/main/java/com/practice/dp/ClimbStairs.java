package com.practice.dp;

// ways to climb 'n' stairs with at-most 'm' steps at a time
public class ClimbStairs {
	private long[] memory;
	private final int n, m;
	public ClimbStairs(int n, int m) {
		// no. of steps to be taken can never be
		// greater than no. of stairs
		if (m > n) {
			this.m = n;
		} else {
			this.m = m;
		}

		this.n = n;
		memory = new long[n + 1];
		seedMemory(this.m);
		countWays(this.n);
	}

	private void seedMemory(int m) {
		memory[0] = 1; // 1-way to not go any stair

		int sum = 1;
		for (int i = 1; i <= m; i++) {
			memory[i] = sum;
			sum += sum;
		}
	}

	private void countWays(int n) {
		for (int i = m + 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				memory[i] += memory[i - j];
			}
		}
	}

	public long waysToClimb(int n) {
		return memory[n];
	}

	public static void main(String[] args) {
		ClimbStairs cs1 = new ClimbStairs(4, 3);
		System.out.println(cs1.waysToClimb(4));
		ClimbStairs cs2 = new ClimbStairs(10, 2);
		System.out.println(cs2.waysToClimb(10));
		System.out.println(cs2.waysToClimb(5));
	}
}