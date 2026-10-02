package DSA.dp.bottomUp.coinchange;

//min of coin whose sum is 5
////11111,1112,113,122,23->last one only 2 coin is needed
public class MinimumNumberOfCoin {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 5;
        System.out.println(coinChange(coins,amount));//2

    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // Base Case: 0 coins needed for amount 0
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        // Base Case: Infinity coins for amount > 0 with 0 coin types
        //if(j/coins[0])->dp[i][j] = j/coins[0]
        for(int j=1;j<=amount;j++){
            //why -1 bez when dp store max+1 and if we initialize max it will overflow so -1.
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){

                if(coins[i-1]<=j){
                    // Min of (Include current coin + 1, Exclude current coin)
                    //since this is unbounded knapsack we have to use dp[i] instead of dp[i-1] because we can take this again
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        int result = dp[n][amount];
        //if still no combination return -1;else return the result
        return result >= Integer.MAX_VALUE - 1 ?-1:result;

    }
}
