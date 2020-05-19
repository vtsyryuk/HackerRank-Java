import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {

    @Test
    void testRepeatedString() {
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
    void testSuperDigit() {
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

    @Test
    void testLargestFriendCircle() {
        assertArrayEquals(Tasks.EMPTY_INT_ARRAY, Tasks.maxCircle(null));
        assertArrayEquals(Tasks.EMPTY_INT_ARRAY, Tasks.maxCircle(new int[0][]));
        assertArrayEquals(Tasks.EMPTY_INT_ARRAY, Tasks.maxCircle(new int[0][0]));

        assertArrayEquals(new int[]{2}, Tasks.maxCircle(new int[][]{{1, 2}}));

        final int[][] input1 = new int[][]{
                {1, 2},
                {1, 3}
        };
        final int[] expected1 = new int[]{2, 3};
        assertArrayEquals(expected1, Tasks.maxCircle(input1));

        final int[][] input2 = new int[][]{
                {1000000000, 23},
                {11, 3778},
                {7, 47},
                {11, 1000000000}
        };
        final int[] expected2 = new int[]{2, 2, 2, 4};
        assertArrayEquals(expected2, Tasks.maxCircle(input2));

        final int[][] input3 = new int[][]{
                {1, 2},
                {3, 4},
                {1, 3},
                {5, 7},
                {5, 6},
                {7, 4}
        };
        final int[] expected3 = new int[]{2, 2, 4, 4, 4, 7};
        assertArrayEquals(expected3, Tasks.maxCircle(input3));
    }
}
