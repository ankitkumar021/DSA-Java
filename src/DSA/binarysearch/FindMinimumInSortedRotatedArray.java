package DSA.binarysearch;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinimumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int mid = pivotPoint(nums);
        return nums[mid + 1];
    }
    public static int pivotPoint(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m < e && nums[m] > nums[m + 1]) {
                return m;
            }
            if (m > s && nums[m] < nums[m - 1]) {
                return m - 1;
            }
            if (nums[m] < nums[s]) {
                e = m - 1;
            } else {
                s = m + 1;
            }

        }
        return -1;

    }
}
