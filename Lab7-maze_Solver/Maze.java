
public class Maze {
	private char[][] grid;

	public Maze(char[][] grid) {
		this.grid = grid;
	}

	public char[][] getGrid() {
		return grid;
	}

	/**
	 * Prints the current state of the maze.
	 */

	public void print() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

}

