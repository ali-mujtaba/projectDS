package com.practice.backtracking;

public class Sudoku {

	int[][] matrix;
	int N;

	Sudoku(int[][] mat) {
		matrix = mat;
		N = matrix.length;
	}

	public static void main(String[] args) {

		// sample 1
		int[][] mat = {
			{3, 0, 6, 5, 0, 8, 4, 0, 0},
			{5, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 8, 7, 0, 0, 0, 0, 3, 1},
			{0, 0, 3, 0, 1, 0, 0, 8, 0},
			{9, 0, 0, 8, 6, 3, 0, 0, 5},
			{0, 5, 0, 0, 9, 0, 6, 0, 0},
			{1, 3, 0, 0, 0, 0, 2, 5, 0},
			{0, 0, 0, 0, 0, 0, 0, 7, 4},
			{0, 0, 5, 2, 0, 6, 3, 0, 0}
		};

		// sample 2
		// int[][] mat = {
		// 	{5, 3, 0, 0, 7, 0, 0, 0, 0},
		// 	{6, 0, 0, 1, 9, 5, 0, 0, 0},
		// 	{0, 9, 8, 0, 0, 0, 0, 6, 0},
		// 	{8, 0, 0, 0, 6, 0, 0, 0, 3},
		// 	{4, 0, 0, 8, 0, 3, 0, 0, 1},
		// 	{7, 0, 0, 0, 2, 0, 0, 0, 6},
		// 	{0, 6, 0, 0, 0, 0, 2, 8, 0},
		// 	{0, 0, 0, 4, 1, 9, 0, 0, 5},
		// 	{0, 0, 0, 0, 8, 0, 0, 7, 9}
		// };

		Sudoku s1 = new Sudoku(mat);
		System.out.println("Problem:-");
		s1.display();
		s1.solveSudoku(0, 0);
		System.out.println("\nSolution:-");
		s1.display();

	}

	boolean isValid(int n, int row, int col) {
		if (row >= 0 && row < N && col >= 0 && col < N) {

			// if cell is already filled
			if (matrix[row][col] != 0) {
				return false;
			}

			// checks if the number 'n' is unique in the row 'row'
			for (int j = 0; j < N; j++) {
				if (matrix[row][j] == n ) {
					return false;
				}
			}

			// checks if the number 'n' is unique in the column 'col'
			for (int i = 0; i < N; i++) {
				if (matrix[i][col] == n) {
					return false;
				}
			}

			// checks if the 'n' is unique in the quadrant of given cell
			int qr = (row / 3) * 3;
			int qc = (col / 3) * 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (matrix[i + qr][j + qc] == n) {
						return false;
					}
				}
			}

			// if number 'n' is unique in its row and column
			return true;
		}

		// if cell co-ordinates are out of bounds
		return false;
	}

	// returns false if cell is in bounds and has not been filled yet
	// otherwise returns true
	boolean isFilled(int row, int col) {
		if (row >= 0 && row < N && col >= 0 && col < N) {

			// if cell is already filled
			if (matrix[row][col] == 0) {
				return false;
			}
		}

		return true;
	}

	// solve Sudoku, filling row-wise
	boolean solveSudoku(int row, int col) {
		if (row >= N) {
			return true;
		}

		// if all the cells in current row are filled,
		// move to next row
		if (col >= N) {
			return solveSudoku(row + 1, 0);
		}

		// if current cell is already filled, skip it and move to next cell
		if (isFilled(row, col)) {
			return solveSudoku(row, col + 1);
		}

		// fill in each valid digit into the cell
		for (int n = 1; n <= 9; n++) {
			if (isValid(n, row, col)) {
				matrix[row][col] = n;
				if (solveSudoku(row, col + 1)) {
					return true;
				}

				// backtrack if the filled digit doesn't lead to solution
				matrix[row][col] = 0;
			}
		}

		return false;

	}

	void display() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}