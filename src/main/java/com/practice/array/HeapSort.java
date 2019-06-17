// Implementation of Heap Sort Algorithm

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {40, 60, 10, 20, 50, 30, 0, 10, 60};
		int n = arr.length;
		System.out.print("\nProvided Array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int m = n;
		while (m > 1) {
			for (int i = m / 2; i >= 1; i--) {
				int l = 2 * i, r = 2 * i + 1;
				int bc;
				if (l <= m && r <= m) {
					bc = arr[l - 1] < arr[r - 1] ? r : l;
				} else if (l <= m) {
					bc = l;
				} else {
					bc = r;
				}
				if (arr[i - 1] < arr[bc - 1]) {
					int t = arr[i - 1];
					arr[i - 1] = arr[bc - 1];
					arr[bc - 1] = t;
				}
			}
			int t = arr[m - 1];
			arr[m - 1] = arr[0];
			arr[0] = t;
			m--;
		}
		System.out.print("Sorted Array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
}