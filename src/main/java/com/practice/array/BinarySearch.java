package com.practice.array;

// Implementation of Binary Search Algorithm
// Assuming entered array is sorted in ascending order.

import java.util.Scanner;

public class BinarySearch {

  public static void main(String[] args) {
    Scanner bs = new Scanner(System.in);
    // System.out.print("Enter the size of array: ");
    // int n = bs.nextInt();
    int n = 5;
    int[] arr = {2, 3, 4, 5, 8};
    System.out.print("Enter the element to look for: ");
    int x = bs.nextInt();
    int top = 0, bot = n - 1, mid;

    while (top <= bot) {
      mid = (top + bot) / 2;
      if (x == arr[mid]) {
        System.out.println("Element found!");
        break;
      } else if (x > arr[mid])
        top = mid + 1;

      else
        bot = mid - 1;
    }

    if (top > bot)
      System.out.println("Element not found!");
  }
}
