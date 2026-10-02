package DSA.stack;

import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreater2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterInCircular(nums)));
    }

    public static int[] nextGreaterInCircular(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        //using hypostatical array with double its size
        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];//to avoid the index out of bound when i>n{original size}
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            if (i < n && !stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(num);
        }
        return ans;
    }
}
