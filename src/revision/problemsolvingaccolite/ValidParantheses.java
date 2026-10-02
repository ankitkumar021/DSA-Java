package revision.problemsolvingaccolite;

import java.util.Stack;
public class ValidParantheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char ch;
            switch(c){
                case ')':
                    ch= stack.pop();
                    if(ch== '{' || ch=='['){
                        return false;
                    }
                    break;
                case '}':
                    ch= stack.pop();
                    if(ch== '(' || ch=='['){
                        return false;
                    }
                    break;
                case ']':
                    ch= stack.pop();
                    if(ch== '(' || ch=='{'){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
