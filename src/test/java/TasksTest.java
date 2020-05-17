import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {

    @Test
    void test1() {
        assertEquals(0, Tasks.repeatedString(null, 10));
        assertEquals(0, Tasks.repeatedString("", 10));
        assertEquals(5, Tasks.repeatedString("a", 5));
        assertEquals(5, Tasks.repeatedString("aaa", 5));
        assertEquals(7, Tasks.repeatedString("aba", 10));
        assertEquals(4, Tasks.repeatedString("abcac", 10));
        assertEquals(5, Tasks.repeatedString("abcac", 11));
        assertEquals(5, Tasks.repeatedString("abcac", 12));
        assertEquals(5, Tasks.repeatedString("abcac", 13));
        assertEquals(6, Tasks.repeatedString("abcac", 14));
        assertEquals(6, Tasks.repeatedString("abcac", 15));
        assertEquals(1000000000000L, Tasks.repeatedString("a", 1000000000000L));
    }

    @Test
    void test2() {
        assertEquals(0, Tasks.superDigit(null, 3));
        assertEquals(0, Tasks.superDigit("", 3));
        assertEquals(3, Tasks.superDigit("148", 3));
        assertEquals(8, Tasks.superDigit("9875", 4));
        assertEquals(9, Tasks.superDigit("123", 3));
        assertEquals(8, Tasks.superDigit("9a8   7d5sawdw", 4));
    }


    @Test
    void testPalindrome() {
        assertEquals(0, Tasks.palindrome(null));
        assertEquals(0, Tasks.palindrome(""));
        assertEquals(1, Tasks.palindrome("a"));
        assertEquals(1, Tasks.palindrome("A"));
        assertEquals(1, Tasks.palindrome("z"));
        assertEquals(1, Tasks.palindrome("Z"));
        assertEquals(7, Tasks.palindrome("mokkori"));
        assertEquals(5, Tasks.palindrome("aabaa"));
    }
}
