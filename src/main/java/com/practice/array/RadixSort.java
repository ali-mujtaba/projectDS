//Implementation of Radix Sort Algorithm

import java.util.*;
public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {53, 89, 150, 36, 633, 233};
		System.out.print("\nProvided array is as follows: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		arr = sort(arr);
		System.out.print("Sorted array is as follows: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	static int[] sort(int arr[]) {
		int n = arr.length;
		int a = 1, b = 0;
		int c = 0;
		boolean flag;
		while (true) {
			flag = false;
			int[] digArr = new int[n];
			int max = 0 , min = 9;
			for (int i = 0; i < n; i++) {
				digArr[i] = arr[i] % (int)Math.pow(10, a) / (int)Math.pow(10, b);
				if (digArr[i] > max)
					max = digArr[i];
				if (digArr[i] < min)
					min = digArr[i];

				if (digArr[i] != 0)
					flag = true;
			}

			if (flag == false)
				break;
			a++; b++;
			int rs = max - min + 1;
			int[] count = new int[rs];

			for (int i = 0; i < n; i++)
				count[digArr[i] - min]++;


			int[] sumCount = new int[rs];
			sumCount[0] = count[0];

			for (int i = 1; i < rs; i++)
				sumCount[i] = count[i] + sumCount[i - 1];

			for (int i = rs - 1; i > 0; i--)
				sumCount[i] = sumCount[i - 1];
			sumCount[0] = 0;
			int[] sortedArr = new int[n];
			for (int i = 0; i < n; i++) {
				int pos = sumCount[digArr[i] - min];
				sortedArr[pos] = arr[i];
				sumCount[digArr[i] - min]++;
			}
			arr = sortedArr;
		}

		return arr;
	}
}