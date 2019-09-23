package com.practice.exercisev2;

import java.io.*;
public class RotateImage {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the size for image matrix: ");
		int N = Integer.parseInt(bufferedReader.readLine());
		int image[][] = new int[N][N];
		System.out.println("Enter image matrix below:-");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("[" + i + ", " + j + "] : ");
				image[i][j] = Integer.parseInt(bufferedReader.readLine());
			}
		}

		System.out.println("\nEntered Image:-");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}

		image = rotateBy90(image);
		System.out.println("\nRotated Image by 90 degree:-");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}

		image = rotateBy180(image);
		System.out.println("\nFurther Rotated Image by 180:-");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}




	}

	static int[][] rotateBy90(int[][] image) {
		int N = image.length;
		for (int layer = 0; layer < N / 2; layer++) {
			for (int i = layer; i < N - 1 - layer; i++) {
				int t = image[layer][i];
				image[layer][i] = image[i][N - 1 - layer];
				image[i][N - 1 - layer] = image[N - 1 - layer][N - 1 - i];
				image[N - 1 - layer][N - 1 - i] = image[N - 1 - i][layer];
				image[N - 1 - i][layer] = t;
			}
		}
		return image;
	}

	static int[][] rotateBy180(int[][] image) {
		int N = image.length;

		for (int layer = 0; layer < N / 2; layer++) {
			for (int i = 0; i < N - 1 - layer; i++) {
				int t = image[layer][i];
				image[layer][i] = image[N - 1 - layer][N - 1 - i];
				image[N - 1 - layer][N - 1 - i] = t;
				t = image[i][N - 1 - layer];
				image[i][N - 1 - layer] = image[N - 1 - i][layer];
				image[N - 1 - i][layer] = t;
			}
		}

		return image;
	}
}