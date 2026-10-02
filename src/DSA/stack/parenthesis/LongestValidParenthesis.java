package DSA.stack.parenthesis;
//https://leetcode.com/problems/longest-valid-parentheses/
import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")()";
        System.out.println(longestValidParenthesisOptimise(s));
        //System.out.println(longestValidParenthesis(s));
    }
    public static int longestValidParenthesisOptimise(String s){
        //optimize
        //since we want to calculate the length so store index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//edge case for when start char is ) when string ")()" and there is nothing in the stack that time so pop will throw error is
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                stack.pop();//if it empty than push again
                if(stack.isEmpty()){
                    stack.push(i);
                }
                maxLength = Math.max(maxLength,i - stack.peek());
            }
        }
        return maxLength;

    }

/*    public static int longestValidParenthesis(String s) {
        //brute force
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j += 2) {
                if (isValid(s.substring(i, j + 1))) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }

        }
        return count == 0;
    }*/
}
