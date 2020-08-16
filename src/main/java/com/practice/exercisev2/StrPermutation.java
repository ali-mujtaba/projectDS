package com.practice.exercisev2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Arrays;

public class StrPermutation {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("String1: ");
		String str1 = bufferedReader.readLine();
		System.out.print("String2: ");
		String str2 = bufferedReader.readLine();

		System.out.println("String2 is a permutation of String1: " + isPermutation(str1, str2));
		System.out.println("String2 is a permutation of String1: " + isPermutation2(str1, str2));
		System.out.println("String2 is a permutation of String1: " + isPermutation3(str1, str2));
	}

	static boolean isPermutation(String str1, String str2) {
		int str1Len = str1.length();
		int str2Len = str2.length();
		if (str1Len != str2Len) {
			return false;
		}

		HashMap<Character, Integer> charCount = new HashMap<>();

		for (int i = 0; i < str1Len; i++) {
			char c = str1.charAt(i);
			if (charCount.containsKey(c)) {
				int currentCount = charCount.get(c);
				currentCount++;
				charCount.put(c, currentCount);
			} else {
				charCount.put(c, 1);
			}
		}

		for (int i = 0; i < str2Len; i++) {
			char c = str2.charAt(i);
			if (charCount.containsKey(c)) {
				int currentCount = charCount.get(c);
				currentCount--;
				if (currentCount == 0) {
					charCount.remove(c);
				} else {
					charCount.replace(c, currentCount);
				}
			} else {
				return false;
			}
		}

		if (charCount.isEmpty()) {
			return true;
		}

		return false;

	}

	static boolean isPermutation2(String str1, String str2) {
		int str1Len = str1.length();
		int str2Len = str2.length();

		if (str1Len != str2Len) {
			return false;
		}

		char charCount[] = new char[256]; // assuming ASCII character set

		for (int i = 0; i < str1Len; i++) {
			char c = str1.charAt(i);
			charCount[c]++;
		}

		for (int i = 0; i < str2Len; i++) {
			char c = str2.charAt(i);
			charCount[c]--;
		}

		for (int i = 0; i < 256; i++) {
			if (charCount[i] != '\u0000') {
				if (charCount[i] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isPermutation3(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		char[] st1 = str1.toCharArray();
		char[] st2 = str2.toCharArray();

		Arrays.sort(st1);
		Arrays.sort(st2);

		for (int i = 0; i < st1.length; i++) {
			if (st1[i] != st2[i]) {
				return false;
			}
		}

		return true;
	}

}

