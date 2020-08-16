/*

Classic problem of Rainwater Trapping

*/
package com.practice.array;

public class RainwaterTrapping {
	public static void main(String[] args) {
		int[] arr = {0, 2, 1, 3, 0, 1, 2, 1, 2, 1};

		int start = 0, end = arr.length;
		while (arr[start] == 0 || arr[end - 1] == 0) {
			if (arr[start] == 0) {
				start++;
			}

			if (arr[end - 1] == 0) {
				end--;
			}
		}
		// System.out.println("start: " + start + "\t End: " + end);
		int lead, trail, water = 0;
		lead = trail = start;
		boolean allowOnce = false;
		while (lead < end) {
			if (arr[lead] >= arr[trail] || allowOnce) {
				for (int i = trail + 1; i < lead; i++) {
					int compareWith = allowOnce ? lead : trail;
					// System.out.println(arr[compareWith] - arr[i]);
					// System.out.println("1)Lead: " + lead + "\t Trail: " + trail);
					water += arr[compareWith] - arr[i];
				}
				allowOnce = false;
				trail = lead;
			}
			lead++;
			// System.out.println("2)Lead: " + lead + "\t Trail: " + trail);
			if (lead == end && trail != end - 1) {
				lead = end - 1;
				for (int i = end - 2; i > trail; i--) {
					if (arr[i] >= arr[lead]) {
						lead = i;
					}
					// System.out.println("3)Lead: " + lead + "\t Trail: " + trail);
				}
				allowOnce = true;
			}
		}


		System.out.println("Water trapped: " + water);
	}
}