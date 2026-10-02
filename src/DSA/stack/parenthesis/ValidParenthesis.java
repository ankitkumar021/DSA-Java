package DSA.stack.parenthesis;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "()[]{)";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char c;
            switch (ch) {
                case ')':
                    c = stack.pop();
                    if (c == '{' || c == '[') {
                        return false;
                    }
                    break;
                case '}':
                    c = stack.pop();
                    if (c == '(' || c == '[') {
                        return false;
                    }
                    break;
                case ']':
                    c = stack.pop();
                    if (c == '{' || c == '(') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();

    }
}
