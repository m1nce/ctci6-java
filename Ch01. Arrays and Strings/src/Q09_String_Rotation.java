import org.junit.Test;
import static org.junit.Assert.*;

public class Q09_String_Rotation {
    /**
     * Checks if s2 is a rotation of s1 using only one call to isSubstring
     * @param s1
     * @param s2
     * @return
     */
    public static boolean stringRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() <= 0) {
            return false;
        }
        s1 += s1;
        return s1.contains(s2);
    }

    @Test
    public void test1() {
        assertTrue(stringRotation("erbottlewat", "waterbottle"));
    }
}
