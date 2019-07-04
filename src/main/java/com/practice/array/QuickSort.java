package com.practice.array;

// Implementation of Quick Sort Algorithm

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {5, 2, 6, 1, 3, 4, 0, 6, 2};
    int n = arr.length;

    System.out.print("\nProvided Array: ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    sort(arr, 0, n - 1);

    System.out.print("Sorted Array: ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  static void sort(int[] arr, int beg, int end) {

    if (beg >= end)
      return;
    int l = beg, r = end;
    int p = l;
    while (l < r) {
      if (p == l) {
        if (arr[p] > arr[r]) {
          int t = arr[p];
          arr[p] = arr[r];
          arr[r] = t;
          p = r;
        } else
          r--;
      } else if (p == r) {
        if (arr[p] < arr[l]) {
          int t = arr[p];
          arr[p] = arr[l];
          arr[l] = t;
          p = l;
        } else
          l++;
      }
    }
    sort(arr, beg, p - 1);
    sort(arr, p + 1, end);
    return;
  }

}
