/*

Write a method to replace all spaces in a string with '%20'.

*/
package com.practice.exercise;

import java.util.Scanner;
public class StrSpaceReplace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string: ");
		String string = sc.nextLine();
		string = replaceSpace(string, "%20");
		System.out.println(string);
	}

	public static String replaceSpace(String str, String replaceStr) {

		int lengthOfString = str.length();
		int lengthOfReplacingString = replaceStr.length();

		int noOfSpaces = 0;
		for (int i = 0; i < lengthOfString; i++) {
			if (str.charAt(i) == ' ')
				noOfSpaces++;
		}

		int lengthOfCharArray = lengthOfString + noOfSpaces * (lengthOfReplacingString - 1);
		char[] strCharArray = new char[lengthOfCharArray];

		for (int i = 0, k = 0; i < lengthOfString; i++) {
			if (str.charAt(i) == ' ') {
				for (int j = 0; j < lengthOfReplacingString; j++, k++) {
					strCharArray[k] = replaceStr.charAt(j);
				}
			} else {
				strCharArray[k] = str.charAt(i);
				k++;
			}
		}

		String string = new String(strCharArray);
		return string;
	}
}