package DSA.dp.bottomUp.knapsackpattern;

public class ParitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};//1,2,3,5->false
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int num:nums){
            sum +=num;
        }
        if(sum%2 == 1){//we cannot divide odd sum into 2
            return false;
        }
        sum /=2;
        return isPartition(nums,sum,n);

    }
    public static boolean isPartition(int[] arr,int sum,int n){
        boolean[][] dp = new boolean[n+1][sum+1];

        // If sum is 0, then answer is true (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
