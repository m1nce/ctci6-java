/**
 * @author Minchan Kim
 * @since  June 19, 2023
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class Q01_Is_Unique {
    /**
     * Determines if a string has all unique characters without an
     * additional data structure (in-place)
     * @param input String to check for unique characters
     * @return indication of string containing duplicate characters
     */
    public static boolean isUnique(String input) {
        // check for duplicates in-place. average O(n^2) implementation
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1() {
        String test1 = "hello";
        assertFalse(isUnique(test1));
    }

    @Test
    public void test2() {
        String test2 = "no duplicates";
        assertTrue(isUnique(test2));
    }
}
