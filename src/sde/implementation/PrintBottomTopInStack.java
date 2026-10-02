package sde.implementation;

import java.util.Stack;
//https://www.geeksforgeeks.org/dsa/print-stack-elements-from-bottom-to-top/

public class PrintBottomTopInStack {
  public  static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      stack.push(6);
      printBottomToTopUsingRec(stack);
    }

    private static void printBottomToTopUsingRec(Stack<Integer> stack) {
      if(stack.isEmpty()){
          return ;
      }
      int item = stack.peek();
      stack.pop();
      System.out.println("remove item " + item);
      //recursive call
        printBottomToTopUsingRec(stack);

      System.out.println("push back the item back to stack");
      stack.push(item);
      System.out.println(stack);
    }

    private static void printBottomToTopIterative(Stack<Integer> stack) {
      Stack<Integer> tempStack = new Stack<>();
      if(stack.isEmpty()){
          return ;
      }
      while(!stack.isEmpty()){
          tempStack.push(stack.pop());
      }
    }
}
