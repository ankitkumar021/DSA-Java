package DSA.stack.implementation;
//https://leetcode.com/problems/implement-stack-using-queues/
import java.util.LinkedList;
import java.util.Queue;
//push and pop from q1
public class ImplementStackUsingQueue {
    public static class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public MyStack() {
        }
        public void push(int x) {
            q1.offer(x);
        }
        public int pop() {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }//pop till last-1 ele
            int last = q1.poll();//remove last ele
            q1 = q2;//swap
            q2 = new LinkedList<>();
            return last;
        }

        public int top() {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }//pop till last-1 ele
            int last = q1.peek();
            q2.offer(last);//only return last element
            q1 = q2;//swap
            q2 = new LinkedList<>();
            return last;
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("top element " + myStack.top()); // return 2
        System.out.println("removed element " + myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False

    }
}
