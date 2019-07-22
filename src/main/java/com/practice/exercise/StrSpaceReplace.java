// Write a method to replace all spaces in a string with '%20'.

import java.util.Scanner;
public class StrSpaceReplace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string: ");
		StringBuffer str = new StringBuffer(sc.nextLine());
		int trueLen = str.length();
		System.out.println("Length: " + trueLen);
		for (int i = 0; i < trueLen; i++) {
			if (str.charAt(i) == ' ') {
				str.replace(i, i + 1, "%20");
				str.setLength(trueLen + 3);
				trueLen = str.length();
			}
		}
		System.out.println(str);
	}
}