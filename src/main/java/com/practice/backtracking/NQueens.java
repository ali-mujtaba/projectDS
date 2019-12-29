package com.practice.backtracking;

public class NQueens {
	int N;

	NQueens(int n) {
		N = n;
	}

	public static void main(String[] args) {
		NQueens nq1 = new NQueens(8);
		nq1.solveNQ();
	}

	void solveNQ() {

		// solution matrix describes the location of Queens
		boolean[][] solution = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = false;
			}
		}

		if (setNQueens(solution, 0) == false) {
			System.out.println("Solution does not exist!");
		} else {
			System.out.println("Solution for " + N + "-Queens:-\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (solution[i][j]) {
						System.out.print("1 ");
					} else {
						System.out.print("0 ");
					}
				}
				System.out.println();
			}
		}
	}

	boolean isAttacked(boolean[][] solution, int row, int col) {
		// checks previous cells in same column
		for (int i = 0; i < row; i++) {
			if (solution[i][col]) {
				return true;
			}
		}

		// checks along upper left diagonal
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (solution[i][j]) {
				return true;
			}
		}

		// checks along upper right diagonal
		for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
			if (solution[i][j]) {
				return true;
			}
		}

		return false;
	}

	// sets N-Queens row-wise at a time
	boolean setNQueens(boolean[][] solution, int row) {
		if (row >= N) {
			// when all slots are examined
			return true;
		}

		for (int i = 0; i < N; i++) {
			if (!isAttacked(solution, row, i)) {
				solution[row][i] = true;

				if (setNQueens(solution, row + 1)) {
					return true;
				}

				// backtrack if the position (row,i) doesn't end up giving a solution
				solution[row][i] = false;
			}
		}

		// case when there is no safe position for Queens, hence, leading to no solution
		return false;
	}
}