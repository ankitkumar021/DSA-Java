package DSA.cyclicsort;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
//Given an integer array nums of length n where all the integers of nums
// are in the range [1, n]
// and each integer appears at most twice,
// return an array of all the integers that appears twice.
public class FindAllDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int current_index = nums[i] - 1;
            if (nums[i] != nums[current_index]) {
                swap(nums, i, current_index);
            } else {
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                list.add(nums[j]);
            }
        }
        return list;

    }

    public static void swap(int[] nums, int i, int current_index) {
        int temp = nums[i];
        nums[i] = nums[current_index];
        nums[current_index] = temp;
    }
}
