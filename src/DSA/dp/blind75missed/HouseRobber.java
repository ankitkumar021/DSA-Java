package DSA.dp.blind75missed;
//adjacent sides house cannot be robbed
//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0]=nums[0];//if 1 house only 1 option rob this

        if(n == 1){
            return nums[0];
        }
        dp[1]=Math.max(nums[0],nums[1]);//if 2 house select max amount house

        for(int i=2;i<n;i++){
            //if 3 house is there and you are at 3rd house either select 3rd and 1st
            //or only select 2nd{as 2 adjacent cannot be selected}
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);

        }
        return dp[n-1];

    }
}
