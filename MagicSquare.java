/*
 * The "Hello Word!" program, just proves you can print to terminal.
 *
 * @author  Yoochan Han
 * @version Beta 0.9
 * @since   2025-12.12
 */
public final class MagicSquare {

    /**
     * Size of the magic square array.
     */
    private static final int SIZE = 9;

    /**
     * The magic number each row, column, and diagonal must sum to.
     */
    private static final int MAGIC_SUM = 15;

    /**
     * Stores the current magic square.
     */
    private static final int[] square = new int[SIZE];

    /**
     * Tracks which numbers from 1 to 9 are already used.
     */
    private static final boolean[] used = new boolean[SIZE + 1];

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        fillSquare(0);
    }

    /**
     * Recursively fills the magic square using backtracking.
     *
     * @param position the current index to fill (0–8)
     */
    private static void fillSquare(int position) {
        if (position == SIZE) {
            if (isMagicSquare()) {
                printSquare();
            }
            return;
        }

        for (int number = 1; number <= SIZE; number++) {
            if (!used[number]) {
                square[position] = number;
                used[number] = true;

                fillSquare(position + 1);

                used[number] = false;
            }
        }
    }

    /**
     * Checks whether the current square is a valid magic square.
     *
     * @return true if the square is magic; false otherwise
     */
    private static boolean isMagicSquare() {
        // Rows
        if (square[0] + square[1] + square[2] != MAGIC_SUM) {
            return false;
        }
        if (square[3] + square[4] + square[5] != MAGIC_SUM) {
            return false;
        }
        if (square[6] + square[7] + square[8] != MAGIC_SUM) {
            return false;
        }

        // Columns
        if (square[0] + square[3] + square[6] != MAGIC_SUM) {
            return false;
        }
        if (square[1] + square[4] + square[7] != MAGIC_SUM) {
            return false;
        }
        if (square[2] + square[5] + square[8] != MAGIC_SUM) {
            return false;
        }

        // Diagonals
        if (square[0] + square[4] + square[8] != MAGIC_SUM) {
            return false;
        }
        if (square[2] + square[4] + square[6] != MAGIC_SUM) {
            return false;
        }

        return true;
    }

    /**
     * Prints the current magic square in 3x3 format.
     */
    private static void printSquare() {
        System.out.println("Magic Square:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(square[i] + " ");
            if (i % 3 == 2) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
