package DSA.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerElementInArray {
  public  static void main(String[] args) {
      int[] arr = {4,5,2,10,8};
      System.out.println(getSmallerToRight(arr));
    }
    private static List<Integer> getSmallerToRight(int[] arr) {
      List<Integer> list = new ArrayList<>();
      Stack<Integer> stack = new Stack<>();
      for(int i=0;i<arr.length;i++){
          list.add(-1);
      }
      for(int i=arr.length-1;i>=0;i--){
          while(!stack.isEmpty() && stack.peek()>arr[i]){
              stack.pop();
          }
          if(!stack.isEmpty()){
              list.set(i,stack.peek());
          }
          stack.push(arr[i]);
      }
      return list;

    }
}
