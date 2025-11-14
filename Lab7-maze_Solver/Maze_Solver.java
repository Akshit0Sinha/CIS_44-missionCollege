
public class Maze_Solver {
	private Maze maze;
	private char[][] grid;

	public Maze_Solver(Maze maze) {
		this.maze = maze;
		this.grid = maze.getGrid();
	}

	/**
	 * Public wrapper method to start the maze-solving process. It should find the
	 * starting 'S' position and initiate the recursive search.
	 * 
	 * @return true if a path is found, false otherwise.
	 */
	// TODO: Find the starting row and column of 'S'
	public boolean solve() {
		int startRow = -1, startCol = -1;

		// Find the starting position 'S'
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'S') {
					startRow = i;
					startCol = j;
					break;
				}
			}
		}
		if (startRow == -1) {
			System.out.println("No starting point 'S' found in the maze!");
			return false;
		}

		return solve(startRow, startCol);
	}

	/**
	 * The core recursive method to solve the maze.
	 * 
	 * @param row The current row position.
	 * @param col The current column position.
	 * @return true if this position leads to a solution, false otherwise.
	 */
	// TODO: Implement the recursive logic with backtracking here.

	// 1. Base Case (Stopping Conditions)
	// Check if out of bounds, a wall, or already visited.
	// Check if the current cell is the finish ('F').

	// 2. Recursive Step
	// Mark the current cell as part of the path.
	// Try moving North, East, South, West.
	// If any direction returns true, then you've found a path, return true.

	// 3. Backtracking
	// If no direction works, un-mark the cell and return false.

	private boolean solve(int row, int col) {
		// Base cases
		// Out of bounds
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
			return false; // Out of bounds
		}
		// Wall or visited
		if (grid[row][col] == '#' || grid[row][col] == '.') {
			return false;
		}
		// Found finish
		if (grid[row][col] == 'F') {
			return true;
		}

		// Mark current cell
		if (grid[row][col] != 'S') {
			grid[row][col] = '.';
		}

		// Recursive exploration (N, E, S, W)
		if (solve(row - 1, col) || solve(row, col + 1) || solve(row + 1, col) || solve(row, col - 1)) {
			return true;
		}

		// Backtrack (unmark)
		if (grid[row][col] != 'S') {
			grid[row][col] = ' ';
		}

		return false;
	}

}
