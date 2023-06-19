public class isUnique {
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
    }
}
