package DSA.dp.bottomUp.coinchange;
//matching
//weight->coin
//W->sum
public class MaximumNumberOfWays {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println(coinChange(coins,sum));
        //11111,1112,113,122,23->5 ways

    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        //here row=0,col=1{opposite to knapsack}
        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){

                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n][amount];

    }
}
