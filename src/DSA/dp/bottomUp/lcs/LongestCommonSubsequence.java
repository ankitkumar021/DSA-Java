package DSA.dp.bottomUp.lcs;
//Subsequence->is not continuous
//substring->is continuous

//https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(printLongestCommonSubsequence(text1,text2));

    }
    public static int longestCommonSubsequence(String text1, String text2) {
        //recursive way->getting TLE
        int m = text1.length();
        int n = text2.length();

        //base case(is the initialisation)
        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1+ dp[i-1][j-1];//take it

                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String printLongestCommonSubsequence(String text1, String text2) {
        //recursive way->getting TLE
        int m = text1.length();
        int n = text2.length();

        //base case(is the initialisation)
        if (m == 0 || n == 0) return null;

        int[][] dp = new int[m + 1][n + 1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1+ dp[i-1][j-1];//take it

                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int i=m;
        int j=n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){

            if(text1.charAt(i-1) == text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1]>dp[i-1][j]){
                j--;
            }
            else{
                i--;
            }

        }

        return sb.reverse().toString();
    }

}
