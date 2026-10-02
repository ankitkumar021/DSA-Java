package DSA.dp.bottomUp.palindromedp;

//https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));//4->bbbb

    }

    public static int longestPalindromeSubseq(String s) {

        //it is based on LCS pattern there we not 2 string
        //but here only 1 is given so created another string with same by reverse
        String sb = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int n = m;

        int[][] dp = new int[m + 1][n + 1];

        if (m == 0 || n == 0) return 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == sb.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];//take it

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }
}
