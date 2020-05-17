import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        final long length = Math.min(s.length(), n);
        long count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        long times = n / s.length();
        long reminder = n % s.length();

        count = times * count;

        for(int i = 0; i < reminder; i++){
            if(s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

    @Test
    void test1() {
        assertEquals(0, repeatedString(null, 10));
        assertEquals(0, repeatedString("", 10));
        assertEquals(5, repeatedString("a", 5));
        assertEquals(5, repeatedString("aaa", 5));
        assertEquals(7, repeatedString("aba", 10));
        assertEquals(4, repeatedString("abcac", 10));
        assertEquals(5, repeatedString("abcac", 11));
        assertEquals(5, repeatedString("abcac", 12));
        assertEquals(5, repeatedString("abcac", 13));
        assertEquals(6, repeatedString("abcac", 14));
        assertEquals(6, repeatedString("abcac", 15));
        assertEquals(1000000000000L, repeatedString("a", 1000000000000L));
    }

    static int superDigit(String n, int k) {
        if (null == n || n.length() == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (Character.isDigit(ch)) {
                sum += Character.digit(ch, 10);
            }
        }

        return digSum(k * digSum(sum));
    }

    // return single digit sum of a number.
    static int digSum(int n) {
        return n == 0 ? 0 : (n % 9 == 0) ? 9 : (n % 9);
    }

    @Test
    void test2() {
        assertEquals(0, superDigit(null, 3));
        assertEquals(0, superDigit("", 3));
        assertEquals(3, superDigit("148", 3));
        assertEquals(8, superDigit("9875", 4));
        assertEquals(9, superDigit("123", 3));
        assertEquals(8, superDigit("9a8   7d5sawdw", 4));
    }

    public static int palindrome(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        final int length = s.length();
        if (1 == length) {
            return 1;
        }
        final TreeMap<String , Integer> uniqValues = new TreeMap<>();
        // table for storing results (2 rows for odd-
        // and even-length palindromes
        final int[][] rows = new int[2][length+1];

        // adding special symbols
        s = "%" + s + "&";

        for (int j = 0; j <= 1; j++) {
            int radius = 0;
            rows[j][0] = 0;
            int i = 1;
            while (i <= length) {
                while (s.charAt(i - radius - 1) == s.charAt(i + j + radius))
                    radius++;
                rows[j][i] = radius;
                int k = 1;
                while ((rows[j][i - k] != radius - k) && (k < radius)) {
                    rows[j][i + k] = Math.min(rows[j][i - k], radius - k);
                    k++;
                }
                radius = Math.max(radius - k,0);
                i += k;
            }
        }

        // remove 'guards'
        s = s.substring(1, s.length()-1);


        uniqValues.put(s.substring(0,1), 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int row = rows[j][i]; row > 0; row--) {
                    uniqValues.put(s.substring(i - row - 1, i - row - 1 + 2 * row + j), 1);
                }
            }
            uniqValues.put(s.substring(i, i + 1), 1);
        }
        return uniqValues.size();
    }

    @Test
    void testPalindrome() {
        assertEquals(7, palindrome("mokkori"));
        assertEquals(5, palindrome("aabaa"));
    }
}
