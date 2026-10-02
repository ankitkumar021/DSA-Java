package DSA.stack.implementation;
//https://leetcode.com/problems/implement-queue-using-stacks/description/
import java.util.Stack;

public class ImplementQueueUsingStack {
    public static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();//push on stack1
            s2 = new Stack<>();//pop and peek from s2
        }
        public void push(int x) {
            s1.push(x);
        }
        public int pop() {
            //you can add edge case like if both stack is empty return
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
        public int peek() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println("Top Element " + myQueue.peek()); // return 1
        System.out.println("Removed Element " + myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

/*public void push(int x) {
    while (!s1.isEmpty()) {
        s2.push(s1.pop());
    }
    s1.push(x);
    while (!s2.isEmpty()) {
        s1.push(s2.pop());
    }
}
public int pop() {
    if (s1.isEmpty()) {
        return 0;
    }
    return s1.pop();
}
public int peek() {
    if (s1.isEmpty()) {
        return 0;
    }
    return s1.peek();
}
public boolean empty() {
    if (s1.size() == 0) {
        return true;
    }
    return false;

}*/
