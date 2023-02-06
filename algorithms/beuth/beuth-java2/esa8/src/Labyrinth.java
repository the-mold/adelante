import java.io.IOException;

/**
 * Class to find a way out of a 10x10 labyrinth.
 */
public class Labyrinth {
    private static final int max_labyrinth_size = 10;
    private final int[][] labyrinth;

    // constant as it is requested in problem description
    private final int posX = 4;
    private final int posY = 5;

    // labyrinth object ids
    private static final int wallID = 1;
    private static final int freeCellID = 0;
    private static final int visitedCellID = 2;

    /**
     * Constructor for the labyrinth.
     * @param inputLabyrinth, input 10x10 int matrix
     */
    public Labyrinth(int[][] inputLabyrinth) {
        this.labyrinth = inputLabyrinth;
    }

    /**
     * Method checks params and initiates path finding.
     */
    public boolean pathFinder() throws IOException {
        // check
        if (!isValidLabyrinth(this.labyrinth)) {
            throw new IOException("invalid labyrinth");
        }

        if (this.labyrinth[this.posY][this.posX] != freeCellID) {
            throw new IOException("start position must be a free cell");
        }

        // print start
        System.out.println("Initial labyrinth");
        this.printLabyrinth();

        if (this.explore(this.posX, this.posY)) {
            this.printLabyrinth();
            System.out.println("Solved!");
            return true;
        } else {
            this.printLabyrinth();
            System.out.println("There is no exit.");
            return false;
        }
    }

    /**
     * Recursive method that checks one free cell after another.
     */
    private boolean explore(int x, int y) {
        // it is a wall
        if (this.labyrinth[y][x] == wallID) {
            return false;
        }

        // was here
        if (this.labyrinth[y][x] == visitedCellID) {
            return false;
        }

        // note that I was here
        this.labyrinth[y][x] = visitedCellID;

        // success
        if (y == 0 || x == 0 || y == max_labyrinth_size - 1 || x == max_labyrinth_size - 1) {
            return true;
        }
        // left
        if (this.explore(x-1,y)) {
            return true;
        }
        // right
        if (this.explore(x+1,y)) {
            return true;
        }
        // down
        if (this.explore(x,y-1)) {
            return true;
        }
        // up
        if (this.explore(x,y+1)) {
            return true;
        }

        return false;
    }

    /**
     * Method to check if a valid labyrinth was provided.
     */
    private static boolean isValidLabyrinth(int[][] inputLabyrinth){
        if (inputLabyrinth.length != max_labyrinth_size) {
            return false;
        }
        for (int i = 0; i < inputLabyrinth.length; i++) {
            if (inputLabyrinth[i].length != max_labyrinth_size) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to print labyrinth.
     */
    private void printLabyrinth() throws IOException {
        String charToPrint;
        System.out.println("==================");
        for (int i = 0; i < this.labyrinth.length; i++) {
            for (int j = 0; j < this.labyrinth[i].length; j++) {
                switch (this.labyrinth[i][j]) {
                    case visitedCellID:
                        charToPrint = "*";
                        break;
                    case wallID:
                        charToPrint = "X";
                        break;
                    case freeCellID:
                        charToPrint = " ";
                        break;
                    default:
                        throw new IOException("illegal entry " + this.labyrinth[i][j]);
                }
                System.out.print(charToPrint + " ");
            }
            System.out.println();
        }
    }
}
