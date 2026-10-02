package DSA.dp.bottomUp.knapsackpattern;
//https://leetcode.com/problems/target-sum/
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));//5
    }
    public static int findTargetSumWays(int[] nums, int target) {
        //same problem
        //https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
        int n = nums.length;
        int sum =0;
        for(int num : nums){
            sum +=num;
        }

        if((sum+target)%2 !=0 || target>sum){//not possible case
            return 0;
        }
        int targetSum = (sum-target)/2;

        int[][] dp = new int[n+1][targetSum+1];

        dp[0][0] = 1;//subset sum =0

        for(int i=1;i<=n;i++){
            for(int j=0;j<=targetSum;j++){

                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][targetSum];

    }
}
