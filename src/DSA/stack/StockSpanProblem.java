package DSA.stack;
//nearest greater to left
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};
        System.out.println(ConsecutiveSmallerOrEqual(arr));
        System.out.println("using brute force" + stockSpanUsingBruteForce(arr));
    }
    public static List<Integer> ConsecutiveSmallerOrEqual(int[] arr){
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>(
                Collections.nCopies(n, 0));
        Stack<Integer> st = new Stack<>();

        // Process each day's price
        for (int i = 0; i < n; i++) {

            // Remove elements from the stack while the current price
            // is greater than or equal to stack's top price
            while (!st.isEmpty() && arr[st.peek()] <=
                    arr[i]) {
                st.pop();
            }

            // If stack is empty, all elements to the left are smaller
            // Else, top of the stack is the last greater element's index
            if (st.isEmpty()) {
                span.set(i, (i + 1));
            } else {
                span.set(i, (i - st.peek()));//since we are storing index in the stack
            }
            // Push the current index to the stack
            st.push(i);
        }
        return span;
    }
    public static List<Integer> stockSpanUsingBruteForce(int[] arr){
        ArrayList<Integer> spanList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int count = 1;
            for(int j = i-1;j>=0;j--){
                if(arr[j] <= arr[i]){
                    count++;
                }else{
                    break;
                }
            }
            spanList.add(count);
        }
        return spanList;
    }
    public static List<Integer> stockSpanOptimize(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){//pop the stack ele when curr ele is greater the stack top
                stack.pop();
            }

            if(stack.isEmpty()){//i+1 because index start with 1 which is min positive val
                ans.add(i+1);
            }
            if(!stack.isEmpty()){
                ans.add(i-stack.peek());// length means total number since we store index not value

            }
            stack.push(i);//keep push the index.
        }
        return ans;
    }

}
