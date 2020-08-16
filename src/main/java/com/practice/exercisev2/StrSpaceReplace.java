package com.practice.exercisev2;

import java.io.*;
public class StrSpaceReplace {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("INPUT: ");
		String string = bufferedReader.readLine();
		System.out.println("OUTPUT: " + fillSpaces(string.toCharArray(), string.trim().length()));
	}

	static String fillSpaces(char[] str, int trueLength) {
		int spaces = 0;

		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaces++;
			}
		}

		int newLength = trueLength + spaces * 2;
		if (str.length < newLength) {
			System.out.println("Insufficient space!");
			return "";
		}

		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;

			} else {
				str[newLength - 1] = str[i];
				newLength--;

			}
		}
		return new String(str);
	}
}