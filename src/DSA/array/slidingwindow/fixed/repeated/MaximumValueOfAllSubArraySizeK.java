package DSA.array.slidingwindow.fixed.repeated;

//https://leetcode.com/problems/sliding-window-maximum/description/
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumValueOfAllSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //  System.out.println(getMaximum(arr,k));
        // getMaximum(arr,k);
        System.out.println(Arrays.toString(maximumSubArraySizeK(arr,k)));
        System.out.println(" practice solution " + Arrays.toString(getMaximumInEveryWindowSIze(arr,k)));
    }
    //sliding window
    private static int[] maximumSubArraySizeK(int[] arr,int k){
        int[] ans = new int[arr.length-k+1];
        // maintain a result/ans array to store the ans
        int ptr=0;
        // here we take a doubly linked list to build the additional logic
        // as we need to insert and remove from both ends
        Deque<Integer> q = new LinkedList<>();
        int i=0,j=0;
        while(j<arr.length){
            //calculation
            // if the temp list is not empty and
            //element on right most side is the largest element
            // then we can simply
            // discard all elements on the left which got added to the deque
            while(!q.isEmpty() && arr[j]>q.peekLast()){
                q.removeLast();
            }
            // add the right most element to the last
            q.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                // if the window size is reached,
                // we need additional logic before sliding the window
                // now, we peek the first element from the deque and
                // maintain it in the ans array
                ans[ptr++]=q.peekFirst();
                // if the first element is same as the left most element of the array
                // which we need to slide,
                // then we remove it from the deque
                if(arr[i]==q.peekFirst()){
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
    public static int[] getMaximumInEveryWindowSIze(int[] arr,int k){
        int[] res = new int[arr.length-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int i=0;
        int j=0;
        int p=0;
        while(j<arr.length){
            while(!queue.isEmpty() && queue.peekLast()<arr[j]){
                queue.removeLast();
            }
            queue.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                res[p++] = queue.peekFirst();
                if(arr[i]== queue.peekFirst()){
                    queue.removeFirst();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
/*//naive approach
    private static void getMaximum(int[] arr, int k) {
        int curMax;
        for(int i=0;i<=arr.length-k;i++){
            curMax = arr[i];
            for(int j=1;j<k;j++){
                if(arr[i+j]>curMax){
                    curMax=arr[i+j];
                }
            }
            System.out.println(curMax);
        }
    }*/
