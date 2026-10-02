package DSA.dp.blind75missed;
//https://leetcode.com/problems/combination-sum-iv/description/
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums,target));//7

    }

    public static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;// target =0,not select anything

        for (int i = 1; i < dp.length; i++) {//< not equal as below for we are start from 1
            for (int num : nums) {//we can take same ele again

                if (num <= i) {//i is sum
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];

    }
}
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.