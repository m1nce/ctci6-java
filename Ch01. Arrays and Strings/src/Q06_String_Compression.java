/**
 * Minchan Kim
 * June 26, 2023
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class Q06_String_Compression {
    /**
     * Performs basic string compression and returns the compressed string
     * if it is shorter than the original string.
     * @param compress string to compress
     * @return compressed string
     */
    public static String stringCompression(String compress) {
        // initialize instance variables
        char[] ca = compress.toCharArray();
        int count = 1;
        char current_letter = ca[0];
        StringBuilder newString = new StringBuilder();

        // write the compressed string into the StringBuilder
        for (int i = 1; i < ca.length; i++) {
            if (ca[i] != current_letter) {
                newString.append(current_letter);
                newString.append(count);
                count = 0;
                current_letter = ca[i];
                count++;
            } else {
                count++;
            }

            // if last letter is reached, automatically add it into the compressed string
            if (i == ca.length - 1) {
                newString.append(current_letter);
                newString.append(count);
            }
        }

        // determines if our compressed string is longer than the string we want to compress
        if (newString.length() >= compress.length()) {
            return compress;
        }
        return newString.toString();
    }

    @Test
    public void test1() {
        assertEquals("a2b1c5a3", stringCompression("aabcccccaaa"));
    }

    @Test
    public void test2() {
        assertEquals("a5b4a4b2d2c1", stringCompression("aaaaabbbbaaaabbddc"));
    }
}
