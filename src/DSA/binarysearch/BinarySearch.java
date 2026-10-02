package DSA.binarysearch;
//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public static void main(String[] args) {
        //we can also solve this using normal binary search
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        //using recursion
        int low = 0;
        int high = nums.length - 1;
        return searchUsingRecursion(nums, target, low, high);
    }

    public static int searchUsingRecursion(int[] nums, int target, int low, int high) {
        //base case
        if (low > high) return -1;

        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchUsingRecursion(nums, target, mid + 1, high);
        }

        return searchUsingRecursion(nums, target, low, mid - 1);
    }
}
