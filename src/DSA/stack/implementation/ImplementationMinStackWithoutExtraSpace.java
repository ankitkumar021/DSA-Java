package DSA.stack.implementation;

import java.util.Stack;

public class ImplementationMinStackWithoutExtraSpace {
    public static class SpecialStack {
        Stack<Integer> stack;
        int minEle;

        public SpecialStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                minEle = x;
            } else {
                if (x >= minEle) {
                    stack.push(x);
                } else {
                    stack.push(2 * x - minEle);
                    minEle = x;
                }

            }
        }

        public void pop() {
            if(stack.isEmpty()) {
                System.out.println("Stack Is Empty");
            }
            else{
                int ele = stack.peek();
                if (ele > minEle) {
                    stack.pop();
                }
                else {
                    //first track and update the previous ele
                    minEle = 2 * minEle - ele;
                    stack.pop();
                }
            }
        }

        public int peek() {
            if (stack.isEmpty())
                return -1;
            else if (stack.peek() >= minEle) {
                stack.peek();
            }
            return minEle;//why min why not stack.peek() because it has encoded value
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int getMin() {
            if (stack.isEmpty()) {
                return -1;
            }
            return minEle;
        }
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(2);// Stack is [2]
        specialStack.push(3);// Stack is [2, 3]
        System.out.println("peek element " + specialStack.peek());//Top element is 3
        specialStack.pop();// Removes 3, stack is [2]
        System.out.println("min element " + specialStack.getMin());// Minimum element is 2
        specialStack.push(1);// Stack is [2, 1]
        System.out.println("min element " + specialStack.getMin());// Minimum element is 1
    }
}
