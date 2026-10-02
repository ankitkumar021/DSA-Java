package sde.morgan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L1 {
    public static void main(String[] args) {
      implementQueue();
    }

    public static void implementQueue(){
        Stack<Integer> stack = new Stack<>();
        int size =3;
        stack.push(1);
        stack.push(2);
        stack.push(3);

        enqueue(stack,size);

        //dequeue(stack,size);

    }

    private static void enqueue(Stack<Integer> stack,int size) {
        Stack<Integer> stack2 = new Stack<>();
        for(int i=0;i<=stack.size();i++){
            stack2.push(stack.pop());
        }
        Queue<Integer> queue = new LinkedList<>();
        if(!stack2.isEmpty()){
            queue.offer(stack2.pop());
        }
        else {
            System.out.println("queue is full");
        }
        for(int i=0;i<queue.size();i++){
            System.out.println((queue.poll()));
        }

    }

    private static void dequeue(Stack<Integer> stack,int size) {
        Queue<Integer> queue = new LinkedList<>();
        if(queue.isEmpty()){
            System.out.println("queue is empty");
        }
        else if(!queue.isEmpty()){
            queue.offer(stack.pop());
        }

    }
}
