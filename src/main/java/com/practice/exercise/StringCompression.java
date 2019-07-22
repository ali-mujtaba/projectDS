// Implement a method to perform basic string compression using the counts of repeated characters.

public class StringCompression {
	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		System.out.println("Entered string: " + args[0]);
		System.out.println("Compressed string: " + obj.compressStr(args[0]));
	}
	public static String compressStr(String str) {
		int l = str.length();
		if (l <= 1)
			return str;
		String cstr = "";
		int count = 1;
		char c = '\0';
		int i;
		for (i = 1; i < l; i++) {
			c = str.charAt(i - 1);
			if (str.charAt(i) != c) {
				cstr = cstr + c + count;
				count = 0;
			}
			count++;
		}
		if (str.charAt(l - 1) != str.charAt(l - 2))
			c = str.charAt(l - 1);
		cstr = cstr + c + count;
		if (cstr.length() >= str.length())
			return str;
		else
			return cstr;
	}
}
