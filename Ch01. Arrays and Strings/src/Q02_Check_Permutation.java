/**
 * Minchan Kim
 * June 19, 2023
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Q02_Check_Permutation {
    public static boolean checkPermutation(String string1, String string2) {
        Hashtable<Character, Integer> storeLetters = new Hashtable<>();
        for (char letter: string1.toCharArray()) {
            if (storeLetters.containsKey(letter)) {
                storeLetters.put(letter, storeLetters.get(letter) + 1);
            } else {
                storeLetters.put(letter, 1);
            }
        }

        for (char letter: string2.toCharArray()) {
            if (!storeLetters.containsKey(letter)) {
                return false;
            } else {
                storeLetters.put(letter, storeLetters.get(letter) - 1);
                if (storeLetters.get(letter) == 0) {
                    storeLetters.remove(letter);
                }
            }
        }
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
