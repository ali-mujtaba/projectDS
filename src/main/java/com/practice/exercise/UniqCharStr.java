// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?
package com.practice.exercise;

import java.util.Scanner;
public class UniqCharStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.next();
		int i;
		for (i = 0 ; i < str.length() ; i++) {
			if (str.toLowerCase().indexOf(str.charAt(i)) != str.toLowerCase().lastIndexOf(str.charAt(i)))
				break;
		}

		if (i < str.length())
			System.out.println("String does NOT have all unique characters! ");
		else
			System.out.println("String has all unique characters! ");
	}
}