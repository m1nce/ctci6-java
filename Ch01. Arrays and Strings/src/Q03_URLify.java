/**
 * Minchan Kim
 * June 19, 2023
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class Q03_URLify {
    /**
     * Replaces all spaces in a string with '%20' in-place
     * @param input string to url-ify
     * @param truelength length of string without extra spaces
     * @return url-ify'd string
     */
    public static char[] urlify(String input, int truelength) {
        // turn string into char array to be in-place within java
        char[] ca = input.toCharArray();
        // account for strings starting at index 0
        truelength--;
        // iterate through ca backwards
        for (int i = ca.length - 1; i > 0; i--) {
            // if a space is encountered while going back to front in the "true length" of string
            // create "%20"
            if (ca[truelength] == ' ') {
                ca[i] = '0';
                ca[i - 1] = '2';
                ca[i - 2] = '%';
                i -= 2;
            } else {
                // if not space, create element on other side
                ca[i] = ca[truelength];
            }
            // indicate movement across "true" string
            truelength--;
        }
        return ca;
    }

    @Test
    public void test1() {
        String test1 = "Mr 3ohn Smith    ";
        // ArrayEquals assertion must be used since char[].toString() returns memory address
        assertArrayEquals("Mr%203ohn%20Smith".toCharArray(), urlify(test1, 13));
    }

    @Test
    public void test2() {
        String test2 = "H3ll0 wor1d!  ";
        assertArrayEquals("H3ll0%20wor1d!".toCharArray(), urlify(test2, 12));
    }

}
