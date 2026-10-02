package DSA.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
   public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k =3;
        System.out.println(findSmallest(arr,k));
    }

    private static int findSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//maxheap
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();

    }
}
