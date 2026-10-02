package DSA.dp.bottomUp.palindromedp;
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class MinimumInsertionToMakePalindromicSubsequence {
    public static void main(String[] args) {
        String s = "mbadm";
//        Output: 2
//        Explanation: String can be "mbdadbm" or "mdbabdm".
        System.out.println(minInsertions(s));

    }
    public static int minInsertions(String s) {
        int n = s.length();
        String sReverse = new StringBuilder(s).reverse().toString();

        //the number of insertion == number of deletion
        return n - lcs(s, sReverse, n);//same for deletion/insertion

    }
    public static int lcs(String s,String s2,int n){
        int[][] dp = new int[n+1][n+1];

        if(n==0){
            return 0;
        }
        for(int i =1;i<=n;i++){
            for(int j=1;j<=n;j++){

                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] =1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
