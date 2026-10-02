package DSA.dp.bottomUp.knapsackpattern;

public class Knapsack {
    public static void main(String[] args) {
        int W = 4;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 1};
        System.out.println(knapsack(W,val,wt));//output=3
    }
    public static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        //using bottom up approach which is basically iterative approach
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                //base case
                if(i==0 || j==0){//initialise 0th row and column
                    dp[i][j] = 0;//i==n,j==W
                }
                else{
                    int pick =0;
                    //pick or not pick
                    if(wt[i-1]<=j){
                        pick = val[i-1]+dp[i-1][j-wt[i-1]];//choice
                    }
                    int notPick = dp[i-1][j];//choice
                    dp[i][j] = Math.max(pick,notPick);
                }

            }
        }
        return dp[n][W];//last ele in the matrix is the ans.
    }
}
