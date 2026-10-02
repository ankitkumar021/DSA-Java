package DSA.dp.blind75missed;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairsUsingDp(3));
    }

    public static int climbStairsUsingDp(int n) {

        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static int climbStairs(int n) {
        //without exrta space,same logic like fibo series
        if (n <= 2) return n;

        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = prev1 + prev2;
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;

    }
}

/*
public int climbStairs(int n) {
    //this solution will give TLE since complixity is > 2pow(30),n =45
    if(n<=2){
        return n;
    }
    return climbStairs(n-1)+climbStairs(n-2);

}*/
