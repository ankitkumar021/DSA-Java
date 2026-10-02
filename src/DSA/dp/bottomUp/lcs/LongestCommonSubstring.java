package DSA.dp.bottomUp.lcs;
//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

//Subsequence->is not continuous
//substring->is continuous

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "acb";
        System.out.println(longCommSubstr(s1,s2));
    }
    public static int longCommSubstr(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        if(m==0 || n==0) return 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;//no match again start with 0
                }
            }
        }
        int maxLen =0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen;
    }
}
