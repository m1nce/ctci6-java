/**
 * Minchan Kim
 * June 25, 2023
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Q05_One_Away {
    /**
     * Checks if two strings are one/zero edits away from one another
     * @param word1 first string
     * @param word2 second string
     * @return strings are one/zero edits away (T/F)
     */
    public static boolean oneAway(String word1, String word2) {
        // if there is more than one difference in length between the two words,
        // then more than one edit is required.
        if (Math.abs(word1.length() - word2.length()) > 1) {
            return false;
        }

        // turn both strings into character arrays to allow iteration through the string
        char[] word1ca = word1.toCharArray();
        char[] word2ca = word2.toCharArray();

        // queue keeps track of the longer character array and the number of edits
        // required to create longer array from the shorter array.
        Queue<Character> checker = new LinkedList<>();
        int different = 0;

        // adds longer character array to queue
        if (word1ca.length < word2ca.length) {
            for (int i = 0; i < word2ca.length; i++) {
                checker.add(word2ca[i]);
            }
        } else {
            for (int i = 0; i < word1ca.length; i++) {
                checker.add(word1ca[i]);
            }
        }

        // counts number of edits required
        if (word1ca.length == word2ca.length) {
            // if two strings are of equal length, then replacing a character
            // is the only thing that can be different
            for (int i = 0; i < word2ca.length; i++) {
                if (checker.remove() != word2ca[i]) {
                    different++;
                }
            }
        } else if (word1ca.length < word2ca.length) {
            for (int i = 0; i < word1ca.length; i++) {
                if (checker.size() == 0) {
                    break;
                }
                if (checker.remove() != word1ca[i]) {
                    different++;
                    i--;
                }
            }
        } else {
            for (int i = 0; i < word2ca.length; i++) {
                if (checker.size() == 0) {
                    break;
                }
                if (checker.remove() != word2ca[i]) {
                    different++;
                    i--;
                }
            }
        }
        different += checker.size();
        return different == 0 || different == 1;
    }

    @Test
    public void test1() {
        assertTrue(oneAway("pale", "ple"));
    }

    @Test
    public void test2() {
        assertFalse(oneAway("pale", "bake"));
    }

    @Test
    public void test3() {
        assertTrue(oneAway("pale", "bale"));
    }

    @Test
    public void test4() {
        assertTrue(oneAway("pales", "pale"));
    }

    @Test
    public void test5() {
        assertFalse(oneAway("bales", "pale"));
    }
}