/**
 * @author Minchan Kim
 * @since  June 19, 2023
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Q02_Check_Permutation {
    /**
     * Given two strings, decide if one is a permutation of the other.
     * @param string1 first string to check permutation
     * @param string2 second string to check permutation
     * @return status of if the arguments are permutations of one another.
     */
    public static boolean checkPermutation(String string1, String string2) {
        // best case scenario: strings are different lengths, meaning permutation is impossible
        if (string1.length() != string2.length()) {
            return false;
        }

        // use hashtable to keep track of unique characters and the number of times they occur
        Hashtable<Character, Integer> storeLetters = new Hashtable<>();

        // add all letters from first string to the frequency hashtable
        for (char letter: string1.toCharArray()) {
            if (storeLetters.containsKey(letter)) {
                storeLetters.put(letter, storeLetters.get(letter) + 1);
            } else {
                storeLetters.put(letter, 1);
            }
        }

        // get rid of letters from the frequency hashtable
        for (char letter: string2.toCharArray()) {
            if (!storeLetters.containsKey(letter)) {
                // returns false if the hashtable does not contain the letter needed
                return false;
            } else {
                storeLetters.put(letter, storeLetters.get(letter) - 1);
                if (storeLetters.get(letter) == 0) {
                    storeLetters.remove(letter);
                }
            }
        }
        // checks if the hashtable is empty. if empty, return true
        return storeLetters.isEmpty();
    }

    @Test
    public void test1() {
        String test11 = "abc";
        String test12 = "cba";
        assertTrue(checkPermutation(test11, test12));
    }
    @Test
    public void test2() {
        String test21 = "hello";
        String test22 = "hello";
        assertTrue(checkPermutation(test21, test22));
    }

    @Test
    public void test3() {
        String test31 = "test";
        String test32 = "set";
        assertFalse(checkPermutation(test31, test32));
    }
}
