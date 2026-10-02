package DSA.cyclicsort;
//https://leetcode.com/problems/find-the-duplicate-number/
//Given an array of integers nums containing n + 1 integers where each
// integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.
public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int current_index = nums[i] - 1;
            if (nums[i] != nums[current_index]) {
                swap(nums, i, current_index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }

        }
        return -1;

    }

    public static void swap(int[] nums, int i, int current_index) {
        int temp = nums[i];
        nums[i] = nums[current_index];
        nums[current_index] = temp;
    }
}
