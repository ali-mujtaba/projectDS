// Given two strings, s1 & s2, write code to check if s2 is a rotation of s1
// using only one call to isSubstring.

import java.util.Scanner;
public class RotationallyRelatedStr {
	public static void main(String[] args) {
		RotationallyRelatedStr obj = new RotationallyRelatedStr();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String 1: ");
		String s1 = sc.next();
		System.out.println("Enter String 2: ");
		String s2 = sc.next();
		if (isSubstring(s1, s2))
			System.out.println(s2 + " is a rotation of " + s1);
		else
			System.out.println(s2 + " is NOT a rotation of " + s1);

	}
	public static boolean isSubstring(String s1, String s2) {
		int i;
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2)
			return false;
		for (i = 0; i < l1; i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				int j = i + 1;
				int k = 1;
				while (k < l2) {
					if (s1.charAt(j) != s2.charAt(k))
						break;
					j = (j + 1) % l1;
					k++;
				}
				if (j == i)
					return true;
			}
		}
		return false;
	}
}