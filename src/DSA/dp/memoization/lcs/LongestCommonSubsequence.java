package DSA.dp.memoization.lcs;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));

    }
    public static int longestCommonSubsequence(String text1, String text2) {
        //recursive way->getting TLE
        int m = text1.length();
        int n = text2.length();

        int[][] memo = new int[m + 1][n + 1];
        //initialize matrix with -1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;

            }
        }

        return lcs(text1, text2, m, n, memo);

    }
    public static int lcs(String text1, String text2, int m, int n, int[][] memo) {
        //base case
        if (m == 0 || n == 0) return 0;

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        //choice diagram
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {//start comparing the last char
            return memo[m][n] = 1 + lcs(text1, text2, m - 1, n - 1, memo);
        }

        //if last character is not matched ,take or not take from both
        else {
            return  memo[m][n] = Math.max(lcs(text1, text2, m - 1, n, memo), lcs(text1, text2, m, n - 1, memo));
        }
        //return memo[m][n];
    }

}
