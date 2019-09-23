package com.practice.exercisev2;

import java.util.Scanner;
import java.util.HashSet;

public class UniqChar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String str = scanner.nextLine();
		System.out.println("Unique: " + UniqChar2.hasUniqueChar(str));
	}

	static boolean hasUniqueChar(String str) {
		boolean charSet[] = new boolean[256]; // Assuming ASCII character set
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			if (charSet[c] == true) {
				return false;
			}
			charSet[c] = true;
		}

		return true;
	}
}

class UniqChar2 {
	static boolean hasUniqueChar(String str) {
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
}