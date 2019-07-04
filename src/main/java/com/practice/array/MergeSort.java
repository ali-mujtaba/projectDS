package com.practice.array;

// Implementation of Merge Sort Algorithm

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {65, 23, 69, 75, 25, 0, 15, 36};
    int n = arr.length;
    System.out.print("\nProvided array is as follows: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    arr = sort(arr, 0, n - 1);

    System.out.print("Sorted array is as follows: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

  }

  static int[] sort(int arr[], int beg, int end) {
    int mid = (beg + end) / 2;
    int sortedArr[] = new int[end - beg + 1];
    for (int i = beg; i < end + 1; i++) {
      sortedArr[end - beg] = arr[i];
    }
    if (beg == end) {
      return sortedArr;
    }

    int left[] = new int[mid - beg + 1];
    int right[] = new int[end - mid];
    left = sort(arr, beg, mid);
    right = sort(arr, mid + 1, end);
    int l = 0, r = 0;
    for (int i = 0; i <= sortedArr.length; i++) {
      if (l < left.length && r < right.length) {
        if (right[r] < left[l]) {
          sortedArr[i] = right[r];
          r++;
        } else {
          sortedArr[i] = left[l];
          l++;
        }
      } else if (r < right.length) {
        sortedArr[i] = right[r];
        r++;
      } else if (l < left.length) {
        sortedArr[i] = left[l];
        l++;
      }
    }
    return sortedArr;
  }
}
