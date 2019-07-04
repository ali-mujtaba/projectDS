package com.practice.array;

// Implementation of Selection Sort Algorithm

import java.util.Scanner;

public class SelectionSort {
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
      int p = i;
      for (j = i + 1; j < n; j++) {
        if (arr[j] < arr[p])
          p = j;
      }
      int t = arr[i];
      arr[i] = arr[p];
      arr[p] = t;
    }

    System.out.print("Sorted Array: ");
    for (i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
