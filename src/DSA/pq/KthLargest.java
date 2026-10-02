package DSA.pq;
//https://leetcode.com/problems/find-k-closest-elements/description/
//Time Complexity:O(nlogk)
//Each of the  elements is processed.
//The heap operations (insertion/removal) take time.
import java.util.PriorityQueue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargest {
   public static void main(String[] args) {
       int[] arr = {10,25,30,40,50,60,70,80};
       int k =3;//this should return 60
       System.out.println(findKthLargest(arr,k));
    }
    public static int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
       return pq.peek();
    }
}
