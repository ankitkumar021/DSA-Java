package DSA.dp.bottomUp.knapsackpattern;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(arr,sum));
    }
   public static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        // If sum is 0, then answer is true
        // (empty subset)
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                //pick or not pick
                if(arr[i-1]<=j){
                    dp[i][j] =  dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n][sum];
    }
}
