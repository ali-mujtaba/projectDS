package com.practice.backtracking;

public class RatInAMaze {

	int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
	int[][] path;
	RatInAMaze() {
		path = new int[maze.length][maze[0].length];
		path[0][0] = 1;
	}

	public static void main(String[] args) {
		RatInAMaze rm1 = new RatInAMaze();
		rm1.displayMaze();
		if (!rm1.findPath(0, 0)) {
			System.out.println("No possible path! ");
			return;
		}
		rm1.displayPath();
	}



	void displayPath() {
		System.out.println("Path:-");
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[0].length; j++) {
				System.out.print(path[i][j] + "\t");
			}
			System.out.println();
		}
	}

	void displayMaze() {
		System.out.println("Maze:- ");
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + "\t");
			}
			System.out.println();
		}
	}


	// checks if the move to cell is possible
	boolean isBlocked(int row, int col) {
		if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 1 ) {
			return false;
		}

		return true;
	}

	boolean findPath(int row, int col) {
		// destination is lower-right corner cell
		if (row == maze.length - 1 && col == maze[0].length - 1) {
			return true;
		}

		// makes move to position 1 unit right
		if (!isBlocked(row, col + 1)) {
			path[row][col + 1] = 1;
			if (findPath(row, col + 1)) {
				return true;
			}

			// backtrack if the move doesn't lead to destination
			path[row][col + 1] = 0;
		}

		// makes move to position 1 unit downwards
		if (!isBlocked(row + 1, col)) {
			path[row + 1][col] = 1;
			if (findPath(row + 1, col)) {
				return true;
			}

			// backtrack if the move doesn't lead to destination;
			path[row + 1][col] = 0;
		}

		// no possible moves lead to solution
		return false;
	}
}