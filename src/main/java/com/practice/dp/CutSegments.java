package com.practice.dp;

import java.util.HashMap;

public class CutSegments {

	static int maximizeCuts(int n, int x, int y, int z) {
		//Your code here
		int maxCuts = cuts(n, x, y, z, new HashMap<Integer, Integer>());
		if (maxCuts == -1) {
			return 0;
		}

		return maxCuts;
	}

	static int cuts(int n, int x, int y, int z, HashMap<Integer, Integer> memory) {
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}

		if (memory.containsKey(n)) {
			return memory.get(n);
		}

		int n1 = cuts(n - x, x, y, z, memory);
		int n2 = cuts(n - y, x, y, z, memory);
		int n3 = cuts(n - z, x, y, z, memory);
		int maxCut = Math.max(Math.max(n1, n2), n3);
		if (maxCut == -1) {
			memory.put(n, -1);
		} else {
			memory.put(n, maxCut + 1);
		}

		return memory.get(n);

	}
	public static void main(String[] args) {
		System.out.println(maximizeCuts(5, 2, 3, 5));
		System.out.println(maximizeCuts(6, 3, 2, 1));
	}
}