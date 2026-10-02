package DSA.stack.implementation;

import java.util.Stack;

//we will take 2 stack {1 stack for push and pop operation 2nd stack for  min ele}

//push is simply add the ele in stack 1 and compare with stack 2 min element if current
// pushed is smaller than the stack 2 element update the stack 2
//pop operation from stack if that ele is min of stack 2 than remove from stack 2 also
//return -1 if both the stack is empty
public class ImplementMinStackWithExtraSpace {
  public static   Stack<Integer> stack = new Stack<>();
  public static   Stack<Integer> supportingStack = new Stack<>();

    public static void main(String[] args) {
        int[] arr = {18, 19, 29, 15, 16};
        ImplementMinStackWithExtraSpace st = new ImplementMinStackWithExtraSpace();
        st.push(18);
        st.push(19);
        st.push(29);
        st.pop();
        st.push(15);
        st.push(16);
        System.out.println(st.getMinEle());
    }

    public static int getMinEle() {
        if(supportingStack.isEmpty()){
            return -1;
        }
        return supportingStack.peek();
    }
    public static void push(int a) {
        stack.push(a);
        // If the supportingStack is empty or the new element is smaller than
        // the top of supportingStack, push it onto supportingStack
        if(supportingStack.isEmpty() || supportingStack.peek()>=a){
            supportingStack.push(a);
        }
    }
    public static int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        int ans = stack.peek();
        stack.pop();
        if(supportingStack.peek() == ans){
            supportingStack.pop();
        }
        return ans;

    }

}
