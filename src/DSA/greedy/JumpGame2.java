package DSA.greedy;
//https://leetcode.com/problems/jump-game-ii/description/
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//       The minimum number of jumps to reach the last index is 2.
//        Jump 1 step from index 0 to 1, then 3 steps to the last index.
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        // 2,3,1,1,4
        //check the choice at every index
        //let says when we are at index 0{i have 2 choices jump step 1 or steps 2}
        //when we jump step 1 we reach index 1(3) ,when we jump 2 we reach index 2(1)
        //but we dont know we have jump step1 or steps 2 to get the min steps to
        //reach at the end so for that go further

        //to check have 2 variable near and far varibale and check all the jumps
        //between the positions and get the farthest position everytime time

        int near = 0;
        int far = 0;
        int jumps = 0;

        // int farthest pos = currentIndex + maximumJump
        //0+2 = 2
        //check all the position in the range

        while (far < nums.length - 1) {

            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            near = far + 1;
            far = farthest;
            jumps++;
        }
        return jumps;
    }
}
