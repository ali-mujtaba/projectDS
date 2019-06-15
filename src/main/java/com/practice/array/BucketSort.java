// Implementation of Bucket Sort Algorithm
import java.util.*;
public class BucketSort {
	public static void main(String[] args) {
		int[] arr = {22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14};
		arr = sort(arr);
		System.out.print("Sorted Array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static int[] sort(int[] arr) {
		int n = arr.length;
		int max = -9999, min = 9999;
		for (int i = 0; i < n; i++) {
			if (arr[i] < min)
				min = arr[i];
			if (arr[i] > max)
				max = arr[i];
		}

		int divider = (int)Math.ceil((max + 1) / 10.0);
		int[][] B = new int[10][divider];

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < divider; j++)
				B[i][j] = -9999;

		for (int i = 0; i < n; i++) {
			int t = arr[i] / divider;
			int j = 0;
			while (B[t][j] != -9999)
				j++;
			B[t][j] = arr[i];
		}


		for (int i = 0; i < 10; i++) {
			int j = 0;
			if (B[i][j] == -9999 || B[i][j + 1] == -9999)
				continue;
			j = 1;
			while (B[i][j] != -9999) {
				if (B[i][j] < B[i][j - 1]) {
					int t = B[i][j];
					B[i][j] = B[i][j - 1];
					B[i][j - 1] = t;
				}
				j++;
			}
		}

		int p = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < divider; j++) {
				if (B[i][j] == -9999)
					break;
				arr[p] =  B[i][j];
				p++;
			}
		}
		return arr;
	}
}