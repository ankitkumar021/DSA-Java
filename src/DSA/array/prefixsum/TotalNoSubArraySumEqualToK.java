package DSA.array.prefixsum;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class TotalNoSubArraySumEqualToK {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {
        //we are maintaining the count of prefix sum in the map
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;
        int prefixSum =0;
        map.put(0,1);//[1,2] at index 1 the sum =0,if we dont add it map before we miss it.
        for(int i =0;i<nums.length;i++){
            prefixSum += nums[i];
            int target = prefixSum - k;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            //in any case prefix is added in the map
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
