package DSA.cyclicsort;

import java.util.ArrayList;
import java.util.List;
//Given an array nums of n integers where nums[i] is in the range [1, n],
//return an array of all the integers in the range [1, n] that do not appear in nums.
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class FindAllNumberDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int current_index = nums[i] - 1;//index starts with 0
            if (nums[i] != nums[current_index]) {
                swap(nums, i, current_index);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {//number is in the range of [1,n]{so->j+1}
                list.add(j + 1);
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
