// Given an image represented by an NxN matrix, where each pixel is 4 bytes.
// Write a method to rotate the image by 90 degrees.
// Rotating by 90 degree anticlockwise.
import java.util.Scanner;
public class RotateBy90 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 'N' for NxN matrix: ");
		int N = sc.nextInt();
		int[][] img = new int[N][N];
		System.out.println("Enter the elements for NxN matrix:- ");
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				img[i][j] = sc.nextInt();

		System.out.println("Image:- ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(img[i][j] + "  ");
			System.out.println();
		}
		int[][] rotImg = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				rotImg[N - j - 1][i] = img[i][j];
			}
		}
		System.out.println("Rotated Image:- ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(rotImg[i][j] + "  ");
			System.out.println();
		}
	}
}