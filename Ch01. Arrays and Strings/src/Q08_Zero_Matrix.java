/**
 * @author Minchan Kim
 * @since  June 26, 20223
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Q08_Zero_Matrix {
    /**
     * If an element in an MxN matrix is 0, its entire row and column are set to 0.
     * @param matrix original matrix
     * @return matrix that has been zero'd
     */
    public static int[][] zeroMatrix(int[][] matrix) {
        Queue<Integer[]> zeroIndices = new LinkedList<>();
        // gets all positions in matrix with 0's
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroIndices.add(new Integer[]{i, j});
                }
            }
        }

        // fills out rows and columns to 0.
        while (!zeroIndices.isEmpty()) {
            // gets the exact x and y positions of 0's
            int x = zeroIndices.peek()[0];
            int y = zeroIndices.remove()[1];

            // fills row with 0's
            for (int i = 0; i < matrix[x].length; i++) {
                matrix[x][i] = 0;
            }

            // fills columns with 0's
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }

        return matrix;
    }

    @Test
    public void test1() {
        int[][] original = new int[][]{{1, 2, 3}, {4, 5, 0}};
        assertArrayEquals(new int[][]{{1, 2, 0}, {0, 0, 0}}, zeroMatrix(original));
    }
}
