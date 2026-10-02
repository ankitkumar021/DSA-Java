package DSA.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementInArray {
   public static void main(String[] args) {
       int[] arr = { 6, 8, 0, 1, 3 };
       //agar hm 8 par aur next ele ko check karna hai right so next ele upar rahna chahiye
       // upar rahne ke liye hmlog ko end ele se start karna hoga stack me dalna taki
       //jab hmlog 8 par jaye to top of stack mera next of 8th ho

       System.out.println(findNextGreater(arr));
    }
    private static List<Integer> findNextGreater(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            list.add(-1);
        }
        for(int i = arr.length-1;i>=0;i--){//we need to first in last out(since we are checking nearest ele
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
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
