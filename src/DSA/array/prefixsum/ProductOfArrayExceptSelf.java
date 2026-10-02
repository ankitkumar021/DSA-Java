package DSA.array.prefixsum;

import java.util.Arrays;
//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static int[] productExceptSelf(int[] nums) {

        //maintain two array left and right
        // who contains product from left to right and vice versa
        //and the res array will have the product of both
        int n = nums.length;
        int[] left = new int[n];//prefix
        int[] right = new int[n];//suffix
        int[] ans = new int[n];

        left[0] = 1;//1 as there nothing before 0th index to multiply
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];//why i-1//left subarray must contains everything before i
        }
        right[n - 1] = 1;//1 as there nothing after nth index to multiply
        for (int j = n - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }
        for (int k = 0; k < n; k++) {//at any index left of k * right of k is tha ans (not k)
            ans[k] = left[k] * right[k];
        }
        return ans;
    }
}
