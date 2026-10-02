package DSA.array.slidingwindow.fixed.sheet;

//https://leetcode.com/problems/subarray-product-less-than-k/description/
public class CountSubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 1) return 0;//product cannot be less than 1
        int left = 0;
        int product = 1;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];//remove the previous ele
                left++;
            }
            //this count is keep increment as right keep increasing
            count += right - left + 1;

        }
        return count;

    }
}
