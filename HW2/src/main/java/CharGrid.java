// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid is the grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int row = 0;
        int col = 0;
        int inirow = 0;
        int inicol = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    if (count == 0) {
                        inirow = i;
                        inicol = j;
                    }

                    if (i > row) {
                        row = i;
                    }
                    if (j > col) {
                        col = j;
                    }
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        } else if (count == 1) {
            return 1;
        } else {
            return (row - inirow + 1) * (col - inicol + 1);
        }

    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int count = 0;
        int[][] up = new int[grid.length][grid[0].length];
        int[][] down = new int[grid.length][grid[0].length];
        int[][] left = new int[grid.length][grid[0].length];
        int[][] right = new int[grid.length][grid[0].length];

        for (int i = up.length - 2; i >= 1; i--) {
            for (int j = up[i].length - 2; j >= 1; j--) {
                if (grid[i][j] == grid[i + 1][j]) {
                    up[i][j] = up[i + 1][j] + 1;
                } else {
                    up[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < down.length; i++) {
            for (int j = 1; j < down[i].length; j++) {
                if (grid[i][j] == grid[i - 1][j]) {
                    down[i][j] = down[i - 1][j] + 1;
                } else {
                    down[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < right.length; i++) {
            for (int j = 1; j < right[i].length; j++) {
                if (grid[i][j] == grid[i][j - 1]) {
                    right[i][j] = right[i][j - 1] + 1;
                } else {
                    right[i][j] = 0;
                }
            }
        }

        for (int i = left.length - 2; i >= 1; i--) {
            for (int j = left[i].length - 2; j >= 1; j--) {
                if (grid[i][j] == grid[i][j + 1]) {
                    left[i][j] = left[i][j + 1] + 1;
                } else {
                    left[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (up[i][j] == down[i][j] && down[i][j] == left[i][j] && left[i][j] == right[i][j] && up[i][j] >= 1 && up[i][j] != ' ') {
                    count++;
                }
            }
        }

        return count;
    }

}
