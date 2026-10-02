package DSA.dp.bottomUp.palindromedp;
//https://leetcode.com/discuss/post/371677/google-onsite-min-deletions-to-make-pali-bulq/
public class MinimumDeletionToMakePalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(minNumberOfDeletionToMakeLPS(s));//5-4=1
    }
    //Find x = LCS ( str , reverse Str)
    //minimum number of deletion required = len(str) - X
    public  static  int minNumberOfDeletionToMakeLPS(String s){
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
        return m-dp[m][n];

    }
}
