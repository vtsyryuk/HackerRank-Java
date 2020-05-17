import java.util.TreeMap;

public final class Tasks {
    private Tasks() {
    }

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

        for (int i = 0; i < reminder; i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
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

    public static int palindrome(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        final int length = s.length();
        if (1 == length) {
            return 1;
        }
        final TreeMap<String, Integer> uniqValues = new TreeMap<>();
        // table for storing results (2 rows for odd-
        // and even-length palindromes
        final int[][] rows = new int[2][length + 1];

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
                radius = Math.max(radius - k, 0);
                i += k;
            }
        }

        // remove 'guards'
        s = s.substring(1, s.length() - 1);


        uniqValues.put(s.substring(0, 1), 1);
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
}
