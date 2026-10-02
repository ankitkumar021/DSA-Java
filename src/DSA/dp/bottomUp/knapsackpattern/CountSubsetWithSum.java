package DSA.dp.bottomUp.knapsackpattern;

public class CountSubsetWithSum {
   public static void main(String[] args) {
      int[] arr = {5, 2, 3, 10, 6, 8};
      int target = 10;
       System.out.println(perfectSum(arr,target));

    }
    static int perfectSum(int[] arr, int target) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][target+1];

        // Base case: There's one way to achieve a
        // sum of 0 (by selecting no elements)
        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){

                if(arr[i-1]<=j){
                    dp[i][j] =  dp[i-1][j-arr[i-1]] + dp[i-1][j] ;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n][target];
    }
}

