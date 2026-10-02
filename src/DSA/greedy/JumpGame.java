package DSA.greedy;
//https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        //Jump 1 step from index 0 to 1, then 3 steps to the last index.

       // int[] nums ={3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length-1;
        int target = n;//start target with last ele

        for(int i = n-1;i>=0;i--){
            //current pos + no of jump
            if((i + nums[i]) >= target){
                target = i;//move target towards left
            }
        }
        return target == 0;//if target reach index 0 means we can jump
    }
}
