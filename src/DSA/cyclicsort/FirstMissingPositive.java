package DSA.cyclicsort;

//Given an unsorted integer array nums. Return the smallest positive integer
//that is not present in nums.
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//number in array cannot be 0 or negative
//https://leetcode.com/problems/first-missing-positive/description/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};//{3,4,-1,2}//{3,0,1}//{3,4,2,1}
        //output: 2;
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int current_index = nums[i] - 1;
            //filtering (-ve),(0)
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[current_index]) {
                swap(nums, i, current_index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;//if array size is [1] return 2,as per question
    }
    public static void swap(int[] nums, int i, int current_index) {
        int temp = nums[i];
        nums[i] = nums[current_index];
        nums[current_index] = temp;
    }
}
