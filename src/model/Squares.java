package model;

/**
 * The very most basic implementation of the Game of Life with the traditional ruleset.
 * This class will be used to initialize the application at launch, and will serve as an important element of testing
 * the GUI, as we know well how this representation will behave.
 *
 * Ruleset:
 * 1) If cell is alive, stay alive if 2 or 3 living neighbours. Else, die.
 * 2) If cell is dead, come to life if exactly 3 neighbours. Else, remain dead.
 */

public class Squares {
    private int[][] grid;  //The grid of values where (0,0) is the top left pixel (1 is a living pixel, 0 is dead)
    private int width;  //The width  of the grid
    private int height; //The height of the grid

    //REQUIRES: x, y >= 1
    //EFFECTS: Constructs a grid of square represented cells of input size (x, y), where all initialized cells are dead.
    public Squares(int x, int y) {
        this.grid = new int[x][y];
        this.width = x;
        this.height = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = 0;
            }
        }
    }

    //REQUIRES: grid to be at least 1x1
    //MODIFIES: this
    //EFFECTS: Sets this = the next generation of cells using the ruleset explained in the class level comment
    public void nextGen(){
        //TODO nextGen()
    }

    //REQUIRES: input cell is alive
    //EFFECTS: Returns true if the input cell has less than 2 neighbours and needs to die.
    public boolean isLonely(int x, int y) {
        //TODO isLonely()
        return true; //stub
    }

    //REQUIRES: input cell is alive
    //EFFECTS: Returns true if the input cell has more than 3 neighbours and needs to die.
    public boolean isOverpopulated(int x, int y) {
        int neighbours = this.aliveNeighbours(x, y);
        return (neighbours > 3);
    }

    //REQUIRES: input cell is dead
    //EFFECTS: Returns true if input space has 3 neighbours exactly and needs to come to life.
    public boolean makeNew(int x, int y) {
        int neighbours = this.aliveNeighbours(x, y);
        return (neighbours == 3);
    }

    //REQUIRES: input cell to be within the grid.
    //EFFECTS: Returns the integer number of living neighbours (0 to 8) of the input cell.
    public int aliveNeighbours(int x, int y) {
        int aliveNeighbours = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((x + i >= 0 && x + i < width) && (y + j >= 0 && y + j < height))
                    aliveNeighbours += grid[x + i][y + j];
            }
        }

        return aliveNeighbours;
    }

    //Used for Testing Purposes
    //GETTERS
    public int getValue(int x, int y) {
        return this.grid[x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //SETTERS
    public void toggleValue(int x, int y) {
        if (this.grid[x][y] == 0) {
            this.grid[x][y] = 1;
        } else {
            this.grid[x][y] = 0;
        }
    }

    public void setValueOne(int x, int y) {
        this.grid[x][y] = 1;
    }

    public void setValueZero(int x, int y) {
        this.grid[x][y] = 0;
    }
}
