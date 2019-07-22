import java.util.*;
public class test {
	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// System.out.println("Enter array:-");
		// int arr[][] = new int[3][2];
		// for (int i = 0; i < 3; i++)
		// 	for (int j = 0; j < 2; j++)
		// 		arr[i][j] = in.nextInt();

		int[][] arr = {{5, 9}, {8, 3}, {4, 1}};
		disp(arr[1]);

	}

	static void disp(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (i == 1)
				return;
			System.out.print(arr[i] + " ");
		}
	}
}