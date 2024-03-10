//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid is the input grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		boolean filled;
		for (int y = 0; y < grid[0].length; y++) {
			filled = true;
			for (int x = 0; x < grid.length; x++) {
				if (!grid[x][y]) {
					filled = false;
					break;
				}
			}

			if (filled) {
				emptyline(y);
				movedown(y);
				emptyline(grid[0].length-1);

				y--;
			}
		}
	}


	private void emptyline(int y) {
		for (int i = 0; i < grid.length; i++) {
			grid[i][y] = false;
		}
	}
	private void movedown(int y) {
		for (int pos = y; pos < grid[0].length-1; pos++) {
			for (int x = 0; x < grid.length; x++) {
				grid[x][y] = grid[x][y+1];
			}
		}
	}



	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
