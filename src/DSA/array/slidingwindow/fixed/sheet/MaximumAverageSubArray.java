package DSA.array.slidingwindow.fixed.sheet;

public class MaximumAverageSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));

    }

    //same logic as maxSubarray sum only thing is divided by k at the end.
    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;//because number can be negative
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            sum += nums[j];

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return (double) maxSum / k;
    }
}
