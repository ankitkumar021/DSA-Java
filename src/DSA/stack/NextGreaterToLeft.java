package DSA.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterToLeft {
   public static void main(String[] args) {
       int[] arr = {1,3,2,4};
       System.out.println(findNextGreaterToLeft(arr));
    }

    private static List<Integer> findNextGreaterToLeft(int[] arr) {
       List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            list.add(-1);
        }
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek()<arr[i]){
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
