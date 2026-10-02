package DSA.stack;
//1047,1544,2696
import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperature(temperatures)));

    }
//next greater to right
    public static int[] dailyTemperature(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;//imp{next index - previous index is our ans}
            }
            stack.push(i);
        }
        return ans;
    }
}
