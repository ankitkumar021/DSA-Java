package DSA.binarysearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {

            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[s]) {//left sorted array
                if (target >= nums[s] && target <= nums[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }

            if (nums[m] <= nums[e]) {//right sorted array
                if (target >= nums[m] && target <= nums[e]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }

            }
        }
        return -1;

    }
}
