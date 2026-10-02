package DSA.stack;

import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestAreaOfHistogram {
    public static void main(String[] args) {
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(heights));
    }
    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        //NSL
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();// Reuse stack

        //NSR
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width = right[i] - left[i] - 1;
            //index comparing(let say when i am 4 (1 and 2 is smallest ele which is at index 5 and 1)
            //so 5-1-1=3(right[i] and left[i] are exclusive)
            maxArea = Math.max(maxArea,heights[i]*width);
        }
        return maxArea;


    }
}
