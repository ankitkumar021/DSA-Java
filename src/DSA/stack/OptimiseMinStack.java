package DSA.stack;

import java.util.Stack;

public class OptimiseMinStack {
    public static Stack<Integer> stack = new Stack<>();
    int minEle;
    public static void main(String[] args) {
        OptimiseMinStack st = new OptimiseMinStack();

        st.push(2);
        st.push(3);
        System.out.println(st.peek() + " ");
        st.pop();
        System.out.print(st.getMin() + " ");
        st.push(1);
        System.out.print(st.getMin() + " ");
    }
    public int getMin(){
        if(stack.isEmpty()){
            return -1;
        }
        return minEle;
    }
    public void push(int a){
        if(stack.isEmpty()){
            stack.push(a);
            minEle = a;
        }
        else{
            if(a>=minEle) {
                stack.push(a);
            }
            else {
                stack.push(2*a-minEle);
                minEle = a;
            }
        }
    }
    public int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        else{
            int ele = stack.peek();
            if(ele>=minEle){
               return stack.pop();
            } else {
                minEle = 2*minEle-ele;//to track the min value
               return stack.pop();
            }
        }
    }
    public int peek(){
        if(stack.isEmpty()){
            return -1;
        }
        else{
            if(stack.peek()>=minEle){
                return stack.peek();
            }else{
                return  minEle;//as here is corrupt value in the stack and actual min val is in minEle
            }
        }
    }
}
