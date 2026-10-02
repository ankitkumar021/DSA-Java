package DSA.pq;
//https://leetcode.com/problems/top-k-frequent-elements/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementInArray {
   public static void main(String[] args) {
       int[] nums = {1,1,1,2,2,3};
       int k = 2;
       System.out.println(Arrays.toString(topKFrequent(nums,k)));
       //[2,1]
       //if in interview asked than Arrays.sort(res).
       //but in leetcode it ask in anyorder

    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);

        }
        //min heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));

        for(int num:map.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int j=0;
        while(j<k){
            res[j] = pq.poll();
            j++;
        }
        return res;


    }
}
