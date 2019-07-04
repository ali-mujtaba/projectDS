// Implementation of Bubble Sort Algorithm

import java.util.*;
public class BubbleSort {
	public static void main(String[] args) {
		Scanner is = new Scanner(System.in);
		System.out.print("Enter the size of array to be sorted: ");
		int n = is.nextInt();
		int i, j;
		int arr[] = new int[n];

		System.out.println("Enter the elements of the array: ");
		for (i = 0; i < n; i++)
			arr[i] = is.nextInt();

		System.out.print("Entered Array: ");

		for (i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for (i = 0; i < n - 1; i++) {
			for (j = 0; j < n - 1 - i; j++) {
				if (arr[j] < arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}

		System.out.print("Sorted Array: ");
		for (i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}