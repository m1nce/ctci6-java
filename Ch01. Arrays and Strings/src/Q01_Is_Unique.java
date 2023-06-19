/**
 * Minchan Kim
 * June 19, 2023
 */

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

    public static void main(String[] args) {
        String test1 = "hello";
        boolean expected1 = false;
        assert expected1 == isUnique(test1);

        String test2 = "no duplicates";
        boolean expected2 = true;
        assert expected2 == isUnique(test2);
    }
}
