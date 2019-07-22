// Given two strings, write a method to decide if one is a permutation of the other.
package com.practice.exercise;

import java.util.Scanner;
public class StrPermutation {
	public static void main(String[] args) {
		StrPermutation obj = new StrPermutation();
		obj.checkPermutation();
	}
	public static void checkPermutation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string 1: ");
		String str1 = sc.next();
		System.out.println("Enter string 2: ");
		String str2 = sc.next();
		int l1 = str1.length();
		int l2 = str2.length();
		if (l1 != l2)
			System.out.println("Entered Strings are NOT permutation of each other. ");
		else {
			int i, j;
			for (i = 0; i < l1; i++) {
				char c = str1.charAt(i);
				int cstr1, cstr2;
				cstr1 = cstr2 = 0;
				for (j = 0; j < l1; j++) {
					if (str1.charAt(j) == c)
						cstr1++;
					if (str2.charAt(j) == c)
						cstr2++;
				}
				if (cstr1 != cstr2)
					break;
			}
			if (i < l1)
				System.out.println("Entered Strings are NOT permutation of each other. ");
			else
				System.out.println("Entered Strings are permutation of each other. ");
		}
	}
}