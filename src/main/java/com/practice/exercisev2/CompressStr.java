package com.practice.exercisev2;

import java.util.*;
public class CompressStr {
	public static void main(String[] args) {
		String text = "abbbbbbbbbbbbbbbbbbbbccccca";
		System.out.println(text);
		System.out.println(compressStr(text));
		System.out.println(compressStr2(text));
	}

	static int compressCount(String str) {
		if (str == null) {
			return 0;
		}

		if (str.length() == 1) {
			return 2;
		}

		int size = str.length();
		char lastChar = str.charAt(0);
		int count = 1, compressCount = 0;

		for (int i = 1; i < size; i++) {
			if (str.charAt(i) == lastChar) {
				count++;
				continue;
			}

			compressCount++;
			compressCount += String.valueOf(count).length();
			lastChar = str.charAt(i);
			count = 1;
		}
		compressCount++;
		compressCount += String.valueOf(count).length();

		return compressCount;
	}

	static String compressStr(String str) {
		int size = str.length();
		int compressedCount = compressCount(str);
		if (compressedCount >= size) {
			return str;
		}

		StringBuffer sb = new StringBuffer(compressedCount);
		char lastChar = str.charAt(0);
		int count = 1, i = 1;
		for (; i < size; i++) {
			if (str.charAt(i) == lastChar) {
				count++;
				continue;
			}
			sb.append(lastChar);
			sb.append(count);
			count = 1;
			lastChar = str.charAt(i);
		}
		sb.append(lastChar);
		sb.append(count);

		return sb.toString();
	}

	static String compressStr2(String str) {
		int size = str.length();
		int compressedCount = compressCount(str);
		if (compressedCount >= size) {
			return str;
		}

		char[] compressedStr = new char[compressedCount];
		char lastChar = str.charAt(0);
		int compressedStrIndex = 0;
		int count = 1;
		for (int i = 1; i < size; i++) {
			if (str.charAt(i) == lastChar) {
				count++;
				continue;
			}

			compressedStr = appendChar(compressedStr, compressedStrIndex, count, lastChar);
			compressedStrIndex += 1 + String.valueOf(count).length();
			lastChar = str.charAt(i);
			count = 1;
		}

		compressedStr = appendChar(compressedStr, compressedStrIndex, count, lastChar);
		compressedStrIndex += 1 + String.valueOf(count).length();

		return new String(compressedStr);
	}

	static char[] appendChar(char[] str, int index, int count, char lastChar) {
		str[index] = lastChar;
		int lengthOfCount = String.valueOf(count).length();
		for (int i = 0; i < lengthOfCount; i++) {
			index++;
			str[index] = String.valueOf(count).charAt(i);
		}

		return str;
	}
}