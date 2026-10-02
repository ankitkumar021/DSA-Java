package DSA.dp.blind75missed;
//here the house is in circular ,
//so you have skip first if select last or skip last if select first
//so to solve this I break into 2 linear array make house robber and solve it by taking the
//max of both the combination
//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }

        int[] loot_skip_firstHouse = new int[n-1];
        int[] loot_skip_lastHouse = new int[n-1];

        for(int i=0;i<n-1;i++){
            loot_skip_firstHouse[i] = nums[i+1];//skip first ele
            loot_skip_lastHouse[i] = nums[i];//skip last ele
        }
        int first = dpHelper(loot_skip_firstHouse);
        int last = dpHelper(loot_skip_lastHouse);

        return Math.max(first,last);

    }
    public static int dpHelper(int[] nums){
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];
        if(n == 1){
            return nums[0];
        }

        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);

        }
        return dp[n-1];

    }
}
