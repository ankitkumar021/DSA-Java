package DSA.array.slidingwindow.fixed.sheet;

//https://leetcode.com/problems/max-consecutive-ones/description/
public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int count = 0;
        int maxCount = 0;

        while (j < nums.length) {
            if (nums[j] == 1) {
                count += 1;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
            j++;
        }
        return maxCount;


    }
}
