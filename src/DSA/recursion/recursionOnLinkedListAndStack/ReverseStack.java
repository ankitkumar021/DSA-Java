package DSA.recursion.recursionOnLinkedListAndStack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        reverseStack(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }

    }

    private static void reverseStack(Stack<Integer> st) {
        Stack<Integer> st1 = new Stack<>();
        if(st.isEmpty()){
            return;
        }
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
        st.addAll(st1);
    }
}
/*public static void reverseStack(Stack<Integer> st) {
    // using recursion
    if(st.isEmpty()){
        return;
    }
    int top= st.pop();//4,3,2,1->top
    reverseStack(st);//at this point st is empty
    insertAtBottom(st,top);

}
public static void insertAtBottom(Stack<Integer> s ,int top){
    //don't confuse with s with st both are same since
    //we pop all the element at the beginning

    if(s.isEmpty()){
        s.push(top);
        return;
    }
    //make empty if not
    int top1 = s.pop();
    insertAtBottom(s,top);

    //after everything is inserted,push last the pop to stack
    //befor going back
    s.push(top1);

}*/
