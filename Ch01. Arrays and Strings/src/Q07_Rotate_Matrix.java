/**
 * @author Minchan Kim
 * @since  June 26, 2023
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class Q07_Rotate_Matrix {
    /**
     * Rotates an NxN (square) matrix 90 degrees in a clockwise direction.
     * @param original_matrix matrix to rotate
     * @return rotated matrix
     */
    public static int[][] rotateMatrix(int[][] original_matrix) {
        // initiate instance variables
        int nrows = original_matrix.length;
        int[][] rotated = new int[nrows][nrows];

        // rotate matrix
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < nrows; j++) {
                rotated[i][j] = original_matrix[nrows - 1 - j][i];
            }
        }

        return rotated;
    }

    @Test
    public void test1() {
        int[][] original = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, rotateMatrix(original));
    }
}
