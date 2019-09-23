package com.practice.exercisev2;

import java.io.*;

public class RotationallyRelatedStr {
	public static void main(String[] args)throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string1: ");
		String str1 = bufferedReader.readLine();
		System.out.println("Enter string2: ");
		String str2 = bufferedReader.readLine();

		System.out.println("String2 is a rotation String1: " + isRotationallyRelated(str1, str2));
	}

	static boolean isRotationallyRelated(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		String compareStr = str2 + str2;
		if (isSubstring(compareStr, str2)) {
			return true;
		}
		return false;
	}

	static boolean isSubstring(String s1, String s2) {
		if (s1.contains(s2)) {
			return true;
		}
		return false;
	}
}