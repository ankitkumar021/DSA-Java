package DSA.stack.parenthesis;

public class MinAddToMakeValidParenthesis {
    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(minParenthesisUsing2Pointer(s));

    }
    public static int minParenthesisUsing2Pointer(String s){
        int open=0;
        int close=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                open++;
            } else if (c==')') {
                open--;
              if (open<0) {
                  close++;
                  open = 0;
              }
            }
        }
        return open+close;
    }
/*    public static int minParenthesis(String s) {
        //using stack
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() != c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }*/

}
