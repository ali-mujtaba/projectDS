package com.practice.bitmanipulation;

public class MonochromeScreen {
	public static void main(String[] args) {

		int w = 24; // in px, should be divisible by 8
		byte[] screen = new byte[9];
		System.out.println("Initial Screen:-");
		showScreen(screen, w);
		screen = drawHorizontalLine(screen, w, 16, 24, 3);
		System.out.println("\nFinal Screen:-");
		showScreen(screen, w);
	}

	static byte[] drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		int height = screen.length / (width / 8);

		// ranges of x1, x2 and y
		if (y <= 0 || y > height || x1 <= 0 || x2 <= 0 || x1 > width || x2 > width) {
			return screen;
		}

		// x1 <= x2 is assumed, swap if otherwise
		if (x1 > x2) {
			int x = x1;
			x1 = x2;
			x2 = x;
		}

		// y > 0 always
		int skipCells = (width / 8) * (height - y); // skip these cells completely to reach y-th row

		int x1Cell = skipCells + (x1 - 1) / 8; // cell containing x1 pixel
		int x2Cell = skipCells + (x2 - 1) / 8; // cell containing x2 pixel

		byte zero = 0;
		if (x1Cell == x2Cell) {
			for (int i = 0; i < x2 - x1 + 1; i++) {
				screen[x1Cell] |= 1 << i;
			}
			screen[x1Cell] = (byte)(screen[x1Cell] << (8 - x2));

			return screen;
		}

		screen[x1Cell] |= setNBitsFromRight(zero, 8 - ((x1 - 1) % 8));
		screen[x2Cell] |= setNBitsFromLeft(zero, ((x2 - 1) % 8) + 1);
		x1Cell++;
		while (x1Cell < x2Cell) {
			screen[x1Cell] = -1;
			x1Cell++;
		}

		return screen;
	}

	static byte setNBitsFromRight(byte a, int N) {
		while (N > 0) {
			N--;
			a |= 1 << (N);
		}
		return a;
	}

	static byte setNBitsFromLeft(byte a, int N) {
		a = setNBitsFromRight(a, 8 - N);
		byte all1s = -1;

		a = (byte)(all1s ^ a);

		return a;
	}

	static void showScreen(byte[] screen, int width) {
		for (int i = 0; i < screen.length; i++) {
			if (i % (width / 8) == 0) {
				System.out.println();
			}

			System.out.print(getBinaryString(screen[i]) + " ");
		}

		System.out.println();
	}

	static String getBinaryString(byte n) {
		String bin = "";
		for (int i = 0; i < Byte.SIZE; i++) {
			boolean bit = BitManipulation.getBit(n & (1 << i), i);
			bin = bit ? "1" + bin : "0" + bin;
		}

		return bin;
	}
}