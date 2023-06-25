/**
 * Minchan Kim
 * June 24, 2023
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Q04_Palindrome_Permutation {
    public static boolean palindromePermutation(String word) {
        // adds all characters besides spaces into hashmap
        HashMap<Character, Integer> characterMap = new HashMap<>();
        for (char letter: word.toLowerCase().toCharArray()) {
            if (letter != ' ') {
                if (characterMap.containsKey(letter)) {
                    characterMap.put(letter, characterMap.get(letter) + 1);
                } else {
                    characterMap.put(letter, 1);
                }
            }
        }

        // checks to see if palindrome permutation is possible. this only happens
        // if there is only one character that has an odd number of occurrences or
        // all characters occur in even occurrences
        boolean centerFulfilled = false;
        for (char letter: characterMap.keySet()) {
            if (characterMap.get(letter) % 2 == 1) {
                // checks to see if there has already been an element that occurred
                // an odd number of times
                if (centerFulfilled == true) {
                    return false;
                }
                // fulfills the one allowance of an element occuring an odd number of times
                centerFulfilled = true;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        String test1 = "Taco cat";
        assertTrue(palindromePermutation(test1));
    }

    @Test
    public void test2() {
        String test2 = "acrerac";
        assertTrue(palindromePermutation(test2));
    }

    @Test
    public void test3() {
        String test3 = "kkaya";
        assertTrue(palindromePermutation(test3));
    }

    @Test
    public void test4() {
        String test4 = "a";
        assertTrue(palindromePermutation(test4));
    }

    @Test
    public void test5() {
        String test5 = "";
        assertTrue(palindromePermutation(test5));
    }

    @Test
    public void test6() {
        String test6 = "jumpy";
        assertFalse(palindromePermutation(test6));
    }
}
