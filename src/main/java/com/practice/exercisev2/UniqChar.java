package com.practice.exercisev2;

import java.util.Scanner;
import java.util.HashSet;

public class UniqChar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String str = scanner.nextLine();
		System.out.println("Unique: " + hasUniqueChar(str));
		System.out.println("Unique: " + hasUniqueChar2(str));
		System.out.println("Unique: " + hasUniqueChar3(str));
		System.out.println("Unique: " + hasUniqueChar4(str));
	}

	static boolean hasUniqueChar(String str) {
		int strLen = str.length();
		if (strLen > 256) {
			return false;
		}
		boolean charSet[] = new boolean[256]; // Assuming ASCII character set
		for (int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			if (charSet[c] == true) {
				return false;
			}
			charSet[c] = true;
		}

		return true;
	}

	static boolean hasUniqueChar2(String str) {
		// System.out.println("Using HashSet");
		int strLen = str.length();
		HashSet<Character> charSet = new HashSet<>(strLen);
		for (int i = 0; i < strLen; i++) {
			if (charSet.contains(str.charAt(i))) {
				return false;
			}
			charSet.add(str.charAt(i));
		}
		return true;
	}

	static boolean hasUniqueChar3(String str) {
		int checker = 0;

		for (int i = 0; i < str.length(); i++) {
			int c = (int)str.charAt(i) - 97;
			if ((checker & (1 << c)) > 0) {
				return false;
			}

			checker |= (1 << c);
		}

		return true;
	}

	static boolean hasUniqueChar4(String str) {
		char[] st = str.toCharArray();
		sort(st, 0, st.length - 1);
		for (int i = 0; i < st.length - 1; i++) {
			if (st[i] == st[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static void sort(char[] arr, int beg, int end) {

		if (beg >= end) {
			return;
		}
		int left = beg;
		int right = end;
		int pivot = left;

		while (left < right) {
			if (pivot == left) {
				if (arr[pivot] > arr[right]) {
					char t = arr[pivot];
					arr[pivot] = arr[right];
					arr[right] = t;
					pivot = right;
				} else {
					right--;
				}
			} else {
				if (arr[pivot] < arr[left]) {
					char t = arr[pivot];
					arr[pivot] = arr[left];
					arr[left] = t;
					pivot = left;
				} else {
					left++;
				}
			}
		}

		sort(arr, beg, pivot - 1);
		sort(arr, pivot + 1, end);
		return;
	}
}

