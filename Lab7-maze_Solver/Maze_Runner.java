
public class Maze_Runner {

	public static void main(String[] args) {

		char[][] mazeData1 = { { '#', '#', '#', '#', '#', '#', '#' }, { '#', 'S', ' ', '#', ' ', ' ', '#' },
				{ '#', ' ', ' ', '#', ' ', '#', '#' }, { '#', ' ', '#', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', '#', 'F', '#' }, { '#', '#', '#', '#', '#', '#', '#' } };

		// maze code
		Maze maze1 = new Maze(mazeData1);
		Maze_Solver solver1 = new Maze_Solver(maze1);

		System.out.println("Original Maze 1:");
		maze1.print();

		if (solver1.solve()) {
			System.out.println("Solution Found:");
		} else {
			System.out.println("No Solution Found:");
		}
		maze1.print();

	}

}


