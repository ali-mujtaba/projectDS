package com.practice.exercisev2;

import java.util.Scanner;
public class TurnRowColZero {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter matrix below: ");
		System.out.print("Enter row: ");
		int M = scanner.nextInt();
		System.out.print("Enter column: ");
		int N = scanner.nextInt();
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("[" + i + ", " + j + "] : ");
				matrix[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Matrix: \n");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		matrix = turnToZero(matrix, M, N);
		System.out.println("Matrix after transition: \n");

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	static int[][] turnToZero(int[][] matrix, int M, int N) {

		boolean[] row = new boolean[M];
		boolean[] column = new boolean[N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			if (row[i]) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < N; j++) {
			if (column[j]) {
				for (int i = 0; i < M; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		return matrix;
	}
}