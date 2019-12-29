package com.practice.backtracking;

public class KnightsTour {
	int N;
	int[][] board;

	// int[] x = {2, 2, 1, 1, -2, -2, -1, -1};
	// int[] y = {1, -1, 2, -2, -1, 1, -2, 2};

	// each pair of (x[i],y[i]) represent a possible move for the knight
	/*

	careful about the order of elements in the x & y arrays
	as they can alter the running time of the algorithm drastically,
	with worst case complexity of 8^(N^2)

	*/

	// Following is a tested order of arrays
	int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
	int[] y = {1, 2, 2, 1, -1, -2, -2, -1};


	public static void main(String[] args) throws Exception {
		KnightsTour kt1 = new KnightsTour();
		kt1.board[0][0] = 0;
		if (!kt1.footprint(0, 0, 1)) {
			System.out.println("Solution does not exist!");
			return;
		}

		kt1.display();
	}

	KnightsTour() {
		N = 8;
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = -1;
			}
		}
	}

	boolean isVisited(int row, int col) {
		if (row < 0 || col < 0) {
			return true;
		}

		if (row >= N || col >= N ) {
			return true;
		}

		if (board[row][col] != -1) {
			return true;
		}

		return false;
	}

	boolean footprint(int row, int col, int moves) throws Exception {
		if (moves >= 64) {
			return true;
		}

		// all possible moves for the knight
		for (int i = 0; i < 8; i++) {
			int nextRow = row + x[i];
			int nextCol = col + y[i];
			if (!isVisited(nextRow, nextCol)) {
				board[nextRow][nextCol] = moves; // making the current move

				if (footprint(nextRow, nextCol, moves + 1)) {
					return true;
				}

				board[nextRow][nextCol] = -1; // backtracking
			}
		}

		return false;
	}


	void display() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}
}