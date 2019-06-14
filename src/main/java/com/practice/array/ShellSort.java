// Implementation of Shell Sort Algorithm

public class ShellSort {
	public static void main(String[] args) {
		int arr[] = {14, 18, 19, 37, 23, 40, 29, 30, 11};
		int i, j;
		System.out.print("Provided Array: ");
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		arr = sort(arr);

		System.out.print("Sorted Array: ");
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int[] sort(int[] arr) {
		int n = arr.length;
		int gap = n / 2;
		int i, j;
		while (gap > 0) {
			for (i = gap; i < n; i++) {
				for (j = i - gap; j >= 0; j = j - gap) {
					if (arr[j] > arr[j + gap]) {
						int t = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = t;
					}
				}
			}
			gap /= 2;
		}
		return arr;
	}
}