// Write an algorithm such that if an element in an MxN matrix is 0,
// its entire row and column are set to 0.
package com.practice.exercise;

import java.util.Scanner;
public class MatZeroElem {
	int row, col;
	int[][] arr;

	public MatZeroElem(int r, int c) {
		row = r;
		col = c;
		arr = new int[row][col];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter M & N for the MxN matrix:- ");
		int M = sc.nextInt();
		int N = sc.nextInt();
		MatZeroElem obj = new MatZeroElem(M, N);
		System.out.println("Enter the elements of the matrix:- ");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				obj.arr[i][j] = sc.nextInt();
			}
		}
		boolean[][] zeroRecord = new boolean[M][N];
		System.out.println("Entered matrix is as follows:- ");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(obj.arr[i][j] + "\t");
				if (obj.arr[i][j] == 0)
					zeroRecord[i][j] = true;
			}
			System.out.println();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (zeroRecord[i][j] == true) {
					obj.zerofy(i, j);
				}
			}
		}
		System.out.println("Manipulated matrix is as follows:- ");
		for (int i = 0; i < obj.row; i++) {
			for (int j = 0; j < obj.col; j++) {
				System.out.print(obj.arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public void zerofy(int r, int c) {
		for (int i = 0; i < row; i++) {
			arr[i][c] = 0;
		}

		for (int i = 0; i < col; i++) {
			arr[r][i] = 0;
		}
	}
}