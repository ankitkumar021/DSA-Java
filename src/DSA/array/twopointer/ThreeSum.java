package DSA.array.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/3sum/description/
//o(n2)
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //  int target = 13;
        //   System.out.println(hasTripletSum(arr,target));
        //  Collections.unmodifiableList(Arrays.asList(arr));
        System.out.println(threeSum(nums));
/*       Output: [[-1,-1,2],[-1,0,1]]
       Explanation:
       nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
       nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
       nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.*/
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {

            //the below check for duplicate i so we have to ignore that
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    //below condition is about if any duplicate number is present
                    //ignore it

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
/*
    private static boolean hasTripletSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int requireSum = target - arr[i];
                if (arr[l] + arr[r] == requireSum) {
                    System.out.println(arr[l] + " " + arr[r] + " " + arr[i]);
                    return true;
                } else if (arr[l] + arr[r] < requireSum) {
                    l++;
                } else {
                    r--;

                }
            }
        }
        return false;
    }*/

