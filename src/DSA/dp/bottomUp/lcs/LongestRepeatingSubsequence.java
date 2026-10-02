package DSA.dp.bottomUp.lcs;
//https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
      String s = "axxzxy";
      System.out.println(longestRepeatingSubsequence(s));

    }
    public static int longestRepeatingSubsequence(String s) {
        String s1 = s;
        int m = s.length();
        int n = m;

        //base case(is the initialisation)
        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                //only diff from LCS is (i!=j)-> i and j should not be equal
                if (s.charAt(i - 1) == s1.charAt(j - 1) && i!=j) {
                    dp[i][j] = 1+ dp[i-1][j-1];//take it

                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
//Input: s = "axxzxy"
//Output: 2
//Explanation: The given array with indexes looks like
//a x x z x y
//0 1 2 3 4 5
//The longest subsequence is "xx". It appears twice as explained below.
//subsequence A
//x x
//0 1  <-- index of subsequence A
//------
//        1 2  <-- index of s
//subsequence B
//x x
//0 1  <-- index of subsequence B
//------
//        2 4  <-- index of s
//We are able to use character 'x' (at index 2 in s) in both
//subsequences as it appears on index 1 in subsequence A and index 0 in subsequence B.