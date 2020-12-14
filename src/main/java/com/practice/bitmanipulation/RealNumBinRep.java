package com.practice.bitmanipulation;

public class RealNumBinRep {
	public static void main(String[] args) {
		System.out.println(getRep2(0.71875));
		System.out.println(getRep2(0.8125));
		System.out.println(getRep2(0.72));
		System.out.println(getRep3(0.71875));
		System.out.println(getRep3(0.8125));
		System.out.println(getRep3(0.72));

		if (!getRep(0.8125, 0, 1)) {
			System.out.println("ERROR");
		}

		if (!getRepBetter(0.8125, 0, 1)) {
			System.out.println("ERROR");
		}

		getRep(0.71875, 0, 1);
		getRepBetter(0.71875, 0, 1);

		if (!getRep(0.72, 0, 1)) {
			System.out.println("ERROR");
		}

		if (!getRepBetter(0.72, 0, 1)) {
			System.out.println("ERROR");
		}
	}

	// optimized getRep() function
	static boolean getRepBetter(double n, int rep, int i) {
		if (i > 24) {
			if (n == 0) {
				System.out.println(BitManipulation.getBinaryString(rep));
				return true;
			}
			return false;
		}

		// will not go for further for recursion if there is no possibility
		if (n < 0)
			return false;

		rep = BitManipulation.setBit(rep, i - 1);
		n -= 1 / Math.pow(2, i);

		if (getRep(n, rep, i + 1))
			return true;

		rep = BitManipulation.clearBit(rep, i - 1);
		n += 1 / Math.pow(2, i);

		if (getRep(n, rep, i + 1))
			return true;

		return false;
	}

	static boolean getRep(double n, int rep, int i) {
		if (i > 24) {
			// System.out.println(BitManipulation.getBinaryString(rep));
			if (n == 0) {
				System.out.println(BitManipulation.getBinaryString(rep));
				return true;
			}
			return false;
		}

		if (getRep(n, rep, i + 1)) {
			return true;
		}
		rep = BitManipulation.setBit(rep, i - 1);
		n -= 1 / Math.pow(2, i);
		if (getRep(n, rep, i + 1)) {
			return true;
		}

		return false;
	}

	static String getRep2(double n) {
		if (n <= 0 || n >= 1) {
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (n > 0) {
			if (binary.length() >= 32) {
				return "ERROR";
			}

			double temp = n * 2;
			if (temp >= 1) {
				binary.append("1");
				n = temp - 1;
			} else {
				binary.append("0");
				n = temp;
			}
		}

		return binary.toString();
	}

	static String getRep3(double n) {
		if (n <= 0 || n >= 1) {
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		double factor = 1;
		while (n > 0) {
			if (binary.length() >= 32) {
				return "ERROR";
			}

			factor = factor / 2;
			// System.out.println(factor);
			if (n >= factor) {
				binary.append("1");
				n -= factor;
			} else {
				binary.append("0");
			}
		}

		return binary.toString();
	}
}
