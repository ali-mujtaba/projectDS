package com.practice.array;

// Implementation of Insertion Sort Algorithm

import java.util.Scanner;

public class InsertionSort {
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

    for (i = 0; i < n; i++) {
      j = i - 1;
      int t = arr[i];

      while (j > -1) {
        if (t < arr[j]) {
          arr[j + 1] = arr[j];
          j--;
        } else
          break;
      }

      j++;
      arr[j] = t;
    }
    System.out.print("Sorted Array: ");
    for (i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

}
